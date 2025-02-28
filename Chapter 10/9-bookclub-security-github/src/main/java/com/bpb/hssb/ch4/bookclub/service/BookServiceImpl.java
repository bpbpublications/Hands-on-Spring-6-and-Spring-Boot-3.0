package com.bpb.hssb.ch4.bookclub.service;

import java.util.Collection;

import com.bpb.hssb.ch4.bookclub.domain.Book;
import com.bpb.hssb.ch4.bookclub.domain.BookCopy;
import com.bpb.hssb.ch4.bookclub.repository.BookRepository;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) throws BookServiceException {
        return bookRepository.createBook(book);
    }

    @Override
    public Book getBook(String bookID) throws BookServiceException {
        return bookRepository.getBook(bookID);
    }

    public Collection<Book> getAllBooks() throws BookServiceException {
        return bookRepository.getAllBooks();
    }

    @Override
    public void removeBook(String bookID) throws BookServiceException {
        bookRepository.deleteBook(bookID);
    }

    @Override
    public BookCopy createBookCopy(Book book) throws BookServiceException {
        return bookRepository.createBookCopy(book);
    }

    @Override
    public void removeBookCopy(String bookId, String copyId) throws BookServiceException {
        bookRepository.deleteBookCopy(bookId, copyId);

    }

    @Override
    public BookCopy getBookCopy(String bookCopyID) throws BookServiceException {
        throw new UnsupportedOperationException("Unimplemented method 'getBookCopy'");
    }

}
