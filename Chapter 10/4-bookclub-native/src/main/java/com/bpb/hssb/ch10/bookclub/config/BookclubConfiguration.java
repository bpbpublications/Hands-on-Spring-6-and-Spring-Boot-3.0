package com.bpb.hssb.ch10.bookclub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bpb.hssb.ch10.bookclub.repository.BookCopyJPARepository;
import com.bpb.hssb.ch10.bookclub.repository.BookJPARepository;
import com.bpb.hssb.ch10.bookclub.service.BookService;
import com.bpb.hssb.ch10.bookclub.service.BookServiceImpl;

@Configuration
public class BookclubConfiguration {

    @Bean
    public BookService bookService(BookJPARepository bookRepository, BookCopyJPARepository bookCopyJPARepository) {
        return new BookServiceImpl(bookRepository, bookCopyJPARepository);
    }
}
