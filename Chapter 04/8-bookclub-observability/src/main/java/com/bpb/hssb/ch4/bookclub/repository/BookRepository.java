package com.bpb.hssb.ch4.bookclub.repository;

import java.util.Collection;

import com.bpb.hssb.ch4.bookclub.domain.Book;
import com.bpb.hssb.ch4.bookclub.domain.BookCopy;

public interface BookRepository {

    public Book createBook(Book book);

    public Book getBook(String bookID);

    public Collection<Book> getAllBooks();

    public Book deleteBook(String bookID);

    public BookCopy createBookCopy(Book book);

    public BookCopy getBookCopy(String bookCopyID);

    public BookCopy deleteBookCopy(String bookID, String bookCopy);
}
