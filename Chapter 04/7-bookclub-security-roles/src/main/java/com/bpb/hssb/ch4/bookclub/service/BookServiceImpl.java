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
    public void removeBook(String bookId) throws BookServiceException {
        Book book = bookRepository.deleteBook(bookId);
        if (book == null) {
            throw new BookServiceException("Can not find the book for bookID " + bookId);
        }
    }

    @Override
    public BookCopy createBookCopy(Book book) throws BookServiceException {
        BookCopy bookCopy = bookRepository.createBookCopy(book);
        if (bookCopy == null) {
            throw new BookServiceException("Can't find the book or the copy");
        }
        return bookCopy;
    }

    @Override
    public void removeBookCopy(String bookId, String copyId) throws BookServiceException {
        BookCopy bookCopy = bookRepository.deleteBookCopy(bookId, copyId);
        if (bookCopy == null) {
            throw new BookServiceException("Can't find the book or copy");
        }
    }

    @Override
    public BookCopy getBookCopy(String bookCopyID) throws BookServiceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookCopy'");
    }

}
