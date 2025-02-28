package com.bpb.hssb.ch4.bookclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.bpb.hssb.ch4.bookclub.service.BookService;
import com.bpb.hssb.ch4.bookclub.service.BookServiceException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String listAllBooks(Model model) throws BookServiceException {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/{bookId}")
    public String listBook(@PathVariable("bookId") String bookId, Model model) throws BookServiceException {
        model.addAttribute("book", bookService.getBook(bookId));
        return "book";
    }
}
