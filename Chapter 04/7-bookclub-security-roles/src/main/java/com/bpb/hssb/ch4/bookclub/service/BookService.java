package com.bpb.hssb.ch4.bookclub.service;

import java.util.Collection;

import com.bpb.hssb.ch4.bookclub.domain.Book;
import com.bpb.hssb.ch4.bookclub.domain.BookCopy;

public interface BookService {

    public Book createBook(Book book) throws BookServiceException;

    public Book getBook(String bookID) throws BookServiceException;

    public Collection getAllBooks() throws BookServiceException;

    public void removeBook(String bookID) throws BookServiceException;

    public BookCopy createBookCopy(Book book) throws BookServiceException;

    public BookCopy getBookCopy(String bookCopyID) throws BookServiceException;

    public void removeBookCopy(String bookID, String copyId2) throws BookServiceException;

}
