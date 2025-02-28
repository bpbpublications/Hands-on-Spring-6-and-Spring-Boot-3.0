package com.bpb.hssb.ch6.bookclub.service;

import com.bpb.hssb.ch6.bookclub.domain.Book;
import com.bpb.hssb.ch6.bookclub.domain.BookCopy;
import com.bpb.hssb.ch6.bookclub.repository.BookCopyJPARepository;
import com.bpb.hssb.ch6.bookclub.repository.BookJPARepository;

public class BookServiceImpl implements BookService {

    private BookJPARepository bookRepository;
    private BookCopyJPARepository bookCopyRepository;

    public BookServiceImpl(BookJPARepository bookRepository, BookCopyJPARepository bookCopyRepository) {
        this.bookRepository = bookRepository;
        this.bookCopyRepository = bookCopyRepository;
    }

    @Override
    public Book createBook(Book book) throws BookServiceException {
        return bookRepository.save(book);
    }

    @Override
    public Book getBook(int bookId) throws BookServiceException {
        return bookRepository.findById(bookId).get();
    }

    public Iterable<Book> getAllBooks() throws BookServiceException {
        return bookRepository.findAll();
    }

    @Override
    public void removeBook(int bookId) throws BookServiceException {
        bookRepository.deleteById(bookId);
    }

    @Override
    public BookCopy createBookCopy(Book book) throws BookServiceException {
        BookCopy bookCopy = BookCopy.builder().book(book).isAvailable(true).build();
        return bookCopyRepository.save(bookCopy);
    }

    @Override
    public void removeBookCopy(int bookId, int copyId) throws BookServiceException {
        bookCopyRepository.deleteById(copyId);
    }

    @Override
    public BookCopy getBookCopy(int bookCopyID) throws BookServiceException {
        return bookCopyRepository.findById(bookCopyID).get();
    }

}
