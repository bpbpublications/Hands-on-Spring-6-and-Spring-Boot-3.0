package com.bpb.hssb.ch7.bookclub.service;

import com.bpb.hssb.ch7.bookclub.domain.Book;
import com.bpb.hssb.ch7.bookclub.domain.BookCopy;

public interface BookService {

    public Book createBook(Book book) throws BookServiceException;

    public Book getBook(int bookId) throws BookServiceException;

    public Iterable<Book> getAllBooks() throws BookServiceException;

    public Book updateBook(Book bookToUpdate) throws BookServiceException;

    public void removeBook(int bookId) throws BookServiceException;

    public Iterable<Book> findByTitleContaining(String titlePart) throws BookServiceException;

    public Iterable<Book> findByAuthorContaining(String authorPart) throws BookServiceException;

    public BookCopy createBookCopy(Book book) throws BookServiceException;

    public BookCopy getBookCopy(int bookCopyId) throws BookServiceException;

    public void removeBookCopy(int bookId, int copyId) throws BookServiceException;

}
