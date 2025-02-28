package com.bpb.hssb.ch5.bookclub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bpb.hssb.ch5.bookclub.repository.BookRepository;
import com.bpb.hssb.ch5.bookclub.repository.JDBCBookRepository;
import com.bpb.hssb.ch5.bookclub.service.BookService;
import com.bpb.hssb.ch5.bookclub.service.BookServiceImpl;

@Configuration
public class BookclubConfiguration {

    @Bean
    public BookRepository bookRepository(JdbcTemplate jdbcTemplate) {
        return new JDBCBookRepository(jdbcTemplate);
    }

    @Bean
    public BookService bookService(BookRepository bookRepository) {
        return new BookServiceImpl(bookRepository);
    }
}
