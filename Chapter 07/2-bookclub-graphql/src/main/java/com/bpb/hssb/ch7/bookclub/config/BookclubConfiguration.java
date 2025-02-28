package com.bpb.hssb.ch7.bookclub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.observation.GraphQlObservationInstrumentation;

import com.bpb.hssb.ch7.bookclub.repository.BookCopyJPARepository;
import com.bpb.hssb.ch7.bookclub.repository.BookJPARepository;
import com.bpb.hssb.ch7.bookclub.service.BookService;
import com.bpb.hssb.ch7.bookclub.service.BookServiceImpl;

import io.micrometer.observation.ObservationRegistry;

@Configuration
public class BookclubConfiguration {

    @Bean
    public BookService bookService(BookJPARepository bookRepository, BookCopyJPARepository bookCopyJPARepository) {
        return new BookServiceImpl(bookRepository, bookCopyJPARepository);
    }

    @Bean
    public GraphQlObservationInstrumentation graphQlObservationInstrumentation(ObservationRegistry registr) {
        return new GraphQlObservationInstrumentation(registr);
    }
}
