package com.bpb.hssb.ch5.bookclub.service;

import com.bpb.hssb.ch5.bookclub.domain.Book;
import com.bpb.hssb.ch5.bookclub.domain.BookCopy;
import com.bpb.hssb.ch5.bookclub.repository.BookRepository;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) throws BookServiceException {
        return bookRepository.saveBook(book);
    }

    @Override
    public Book getBook(int bookId) throws BookServiceException {
        return bookRepository.findBookById(bookId);
    }

    public Iterable<Book> getAllBooks() throws BookServiceException {
        return bookRepository.findAllBooks();
    }

    @Override
    public void removeBook(int bookId) throws BookServiceException {
        Book book = bookRepository.deleteBook(bookId);
        if (book == null) {
            throw new BookServiceException("Can not find the book for bookID " + bookId);
        }
    }

    @Override
    public BookCopy createBookCopy(Book book) throws BookServiceException {
        BookCopy bookCopy = bookRepository.saveBookCopy(book);
        if (bookCopy == null) {
            throw new BookServiceException("Can't find the book or the copy");
        }
        return bookCopy;
    }

    @Override
    public void removeBookCopy(int bookId, int copyId) throws BookServiceException {
        BookCopy bookCopy = bookRepository.deleteBookCopy(bookId, copyId);
        if (bookCopy == null) {
            throw new BookServiceException("Can't find the book or copy");
        }
    }

    @Override
    public BookCopy getBookCopy(int bookCopyID) throws BookServiceException {
        throw new UnsupportedOperationException("Unimplemented method 'getBookCopy'");
    }

}
