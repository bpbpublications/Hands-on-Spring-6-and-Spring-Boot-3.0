package com.bpb.hssb.ch4.bookclub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bpb.hssb.ch4.bookclub.repository.BookRepository;
import com.bpb.hssb.ch4.bookclub.repository.InMemoryBookRepository;
import com.bpb.hssb.ch4.bookclub.service.BookService;
import com.bpb.hssb.ch4.bookclub.service.BookServiceImpl;

@Configuration
public class BookclubConfiguration {

    @Bean
    public BookRepository bookRepository() {
        return new InMemoryBookRepository();
    }

    @Bean
    public BookService bookService(BookRepository bookRepository) {
        return new BookServiceImpl(bookRepository);
    }
}
