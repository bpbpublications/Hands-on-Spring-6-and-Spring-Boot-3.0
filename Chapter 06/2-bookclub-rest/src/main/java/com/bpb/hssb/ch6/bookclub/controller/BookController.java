package com.bpb.hssb.ch6.bookclub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bpb.hssb.ch6.bookclub.domain.Book;
import com.bpb.hssb.ch6.bookclub.domain.BookCopy;
import com.bpb.hssb.ch6.bookclub.service.BookService;
import com.bpb.hssb.ch6.bookclub.service.BookServiceException;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {

        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable int bookId) throws BookServiceException {
        return bookService.getBook(bookId);
    }

    @GetMapping
    public Iterable<Book> getAllBooks() throws BookServiceException {
        return bookService.getAllBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) throws BookServiceException {
        return bookService.createBook(book);
    }

    @DeleteMapping("/{bookId}")
    public void removeBook(@PathVariable int bookId) throws BookServiceException {
        bookService.removeBook(bookId);
    }

    @PostMapping("/{bookId}/copies")
    @ResponseStatus(HttpStatus.CREATED)
    public BookCopy createBookCopy(@PathVariable int bookId) throws BookServiceException {
        Book book = bookService.getBook(bookId);
        if (book != null) {
            return bookService.createBookCopy(book);
        } else {
            throw new BookServiceException("The bookId not found");
        }
    }

    @GetMapping("/{bookId}/copies/{copyId}")
    public BookCopy getBookCopy(@PathVariable int bookId,  @PathVariable int copyId) throws BookServiceException {
        return bookService.getBookCopy(copyId);
    }

    @DeleteMapping("/{bookId}/copies/{copyId}")
    public void removeBookCopy(@PathVariable int bookId, @PathVariable int copyId) throws BookServiceException {
        bookService.removeBookCopy(bookId, copyId);
    }
}
