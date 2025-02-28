package com.bpb.hssb.ch5.bookclub.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.bpb.hssb.ch5.bookclub.domain.Book;
import com.bpb.hssb.ch5.bookclub.domain.BookCopy;

public class JDBCBookRepository implements BookRepository {

    private JdbcTemplate jdbcTemplate;

    public JDBCBookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book saveBook(Book book) {

        String sql = "INSERT INTO book (book_id, isbn, title, author, publication_year) VALUES (?, ?, ?, ?, ?)";
        int bookId = getBookId();
        book.setBookId(bookId);
        jdbcTemplate.update(sql, book.getBookId(), book.getIsbn(), book.getTitle(), book.getAuthor(),
                book.getPublicationYear());
        return book;
    }

    @Override
    @Transactional
    public Book findBookById(int bookId) {

        String sql = "SELECT book_id, isbn, title, author, publication_year FROM book WHERE book_id = ?";
        Book book = jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> new Book(
                        rs.getInt("book_id"),
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("publication_year"),
                        new ArrayList<>()),
                bookId);

        if (book != null) {
            String copySql = "SELECT copy_id, is_available FROM book_copy WHERE book_id = ?";
            List<BookCopy> copies = jdbcTemplate.query(
                    copySql,
                    (rs, rowNum) -> new BookCopy(
                            rs.getInt("copy_id"),
                            book,
                            rs.getBoolean("is_available")),
                    bookId);
            book.setCopies(copies);
        }

        return book;
    }

    @Override
    public Iterable<Book> findAllBooks() {

        String sql = "SELECT book_id, isbn, title, author, publication_year FROM book";
        List<Book> books = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Book(
                        rs.getInt("book_id"),
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("publication_year"),
                        new ArrayList<>()));
        return books;
    }

    @Override
    @Transactional
    public Book deleteBook(int bookId) {

        String deleteCopiesSql = "DELETE FROM book_copy WHERE book_id= ?";
        String deleteBookSql = "DELETE FROM book WHERE book_id = ?";
        Book book = findBookById(bookId);
        jdbcTemplate.update(deleteCopiesSql, bookId);
        jdbcTemplate.update(deleteBookSql, bookId);
        return book;
    }

    @Override
    @Transactional
    public BookCopy saveBookCopy(Book book) {

        String checkBookSql = "SELECT COUNT(*) FROM book WHERE book_id = ?";
        Integer count = jdbcTemplate.queryForObject(checkBookSql, Integer.class, book.getBookId());

        if (count != null && count > 0) {
            int bookCopyId = getBookCopyId(book);
            BookCopy bookCopy = new BookCopy(bookCopyId, book, true);
            String insertCopySql = "INSERT INTO book_copy (copy_id, book_id, is_available) VALUES (?, ?, ?)";
            jdbcTemplate.update(insertCopySql, bookCopy.getCopyId(), book.getBookId(), bookCopy.isAvailable());
            return bookCopy;
        } else {
            throw new IllegalArgumentException("Book with ID " + book.getBookId() + " does not exist.");
        }

    }

    @Override
    public BookCopy deleteBookCopy(int bookId, int copyId) {

        String sql = "DELETE FROM book_copy WHERE copy_id= ?";
        BookCopy bookCopy = findBookCopyById(copyId);
        jdbcTemplate.update(sql, copyId);
        return bookCopy;
    }

    @Override
    public BookCopy findBookCopyById(int copyId) {

        String sql = "SELECT copy_id, book_id, is_available FROM book_copy WHERE copy_id = ?";
        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> new BookCopy(
                        rs.getInt("copy_id"),
                        findBookById(rs.getInt("book_id")),
                        rs.getBoolean("is_available")),
                copyId);
    }

    private int getBookId() {
        return (int) (Math.random() * (10000 - 100 + 1)) + 100;
    }

    private synchronized int getBookCopyId(Book book) {
        return (10 * book.getBookId()) + (int) (Math.random() * (10000 - 100 + 1));

    }

 
}
