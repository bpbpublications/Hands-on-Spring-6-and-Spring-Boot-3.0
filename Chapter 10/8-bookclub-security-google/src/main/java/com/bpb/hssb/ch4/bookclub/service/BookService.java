package com.bpb.hssb.ch4.bookclub.service;

import java.util.Collection;

import com.bpb.hssb.ch4.bookclub.domain.Book;
import com.bpb.hssb.ch4.bookclub.domain.BookCopy;

public interface BookService {

    public Book createBook(Book book) throws BookServiceException;

    public Book getBook(String bookId) throws BookServiceException;

    public Collection<Book> getAllBooks() throws BookServiceException;

    public void removeBook(String bookId) throws BookServiceException;

    public BookCopy createBookCopy(Book book) throws BookServiceException;

    public BookCopy getBookCopy(String bookCopyId) throws BookServiceException;

    public void removeBookCopy(String bookId, String copyId) throws BookServiceException;

}
