package com.bpb.hssb.ch9.bookclub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bpb.hssb.ch9.bookclub.repository.BookCopyRepository;
import com.bpb.hssb.ch9.bookclub.repository.BookRepository;
import com.bpb.hssb.ch9.bookclub.service.BookService;
import com.bpb.hssb.ch9.bookclub.service.BookServiceImpl;

@Configuration
public class BookclubConfiguration {

    @Bean
    public BookService bookService(BookRepository bookRepository, BookCopyRepository bookCopyRepository) {
        return new BookServiceImpl(bookRepository, bookCopyRepository);
    }
}
