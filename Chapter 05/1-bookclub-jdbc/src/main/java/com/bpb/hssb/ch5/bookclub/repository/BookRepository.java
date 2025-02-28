package com.bpb.hssb.ch5.bookclub.repository;

import com.bpb.hssb.ch5.bookclub.domain.Book;
import com.bpb.hssb.ch5.bookclub.domain.BookCopy;

public interface BookRepository {

    public Book saveBook(Book book);

    public Book findBookById(int bookId);

    public Iterable<Book> findAllBooks();

    public Book deleteBook(int bookId);

    public BookCopy saveBookCopy(Book book);

    public BookCopy findBookCopyById(int bookCopyId);

    public BookCopy deleteBookCopy(int bookId, int bookCopyId);
}
