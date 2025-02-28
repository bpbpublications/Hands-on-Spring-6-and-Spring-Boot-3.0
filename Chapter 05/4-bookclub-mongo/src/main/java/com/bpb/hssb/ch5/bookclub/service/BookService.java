package com.bpb.hssb.ch5.bookclub.service;

import com.bpb.hssb.ch5.bookclub.domain.Book;
import com.bpb.hssb.ch5.bookclub.domain.BookCopy;
import com.bpb.hssb.ch5.bookclub.domain.Comment;

public interface BookService {

    public Book createBook(Book book) throws BookServiceException;

    public Book getBook(int bookId) throws BookServiceException;

    public Iterable<Book> getAllBooks() throws BookServiceException;

    public void removeBook(int bookId) throws BookServiceException;

    public BookCopy createBookCopy(Book book) throws BookServiceException;

    public BookCopy getBookCopy(int bookCopyId) throws BookServiceException;

    public void removeBookCopy(int bookId, int copyId) throws BookServiceException;

    public void createComment(Comment comment);

    public Iterable<Comment> findCommentsByBookId(int bookId);

}
