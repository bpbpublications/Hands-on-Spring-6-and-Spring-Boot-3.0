package com.bpb.hssb.ch7.bookclub.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.bpb.hssb.ch7.bookclub.domain.Book;
import com.bpb.hssb.ch7.bookclub.domain.BookInput;
import com.bpb.hssb.ch7.bookclub.service.BookService;
import com.bpb.hssb.ch7.bookclub.service.BookServiceException;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public Book bookById(@Argument int bookId) throws BookServiceException {
        return bookService.getBook(bookId);
    }

    @QueryMapping
    public Iterable<Book> booksByTitle(@Argument String title) throws BookServiceException {
        return bookService.findByTitleContaining(title);
    }

    @QueryMapping
    public Iterable<Book> booksByAuthor(@Argument String author) throws BookServiceException {
        return bookService.findByAuthorContaining(author);
    }

    @MutationMapping
    public Book createBook(@Argument BookInput book) throws BookServiceException {
        Book bookToAdd = Book.builder().isbn(book.getIsbn()).title(book.getTitle())
                .author(book.getAuthor()).publicationYear(book.getPublicationYear()).build();
        return bookService.createBook(bookToAdd);
    }

    @MutationMapping
    public Book updateBook(@Argument BookInput book) throws BookServiceException {
        Book bookToUpdate = Book.builder().isbn(book.getIsbn()).title(book.getTitle())
                .author(book.getAuthor()).publicationYear(book.getPublicationYear()).build();
        return bookService.updateBook(bookToUpdate);
    }

}
