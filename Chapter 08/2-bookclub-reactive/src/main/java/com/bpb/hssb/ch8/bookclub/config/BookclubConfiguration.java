package com.bpb.hssb.ch8.bookclub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bpb.hssb.ch8.bookclub.repository.CommentRepository;
import com.bpb.hssb.ch8.bookclub.service.CommentService;
import com.bpb.hssb.ch8.bookclub.service.CommentServiceImpl;

@Configuration
public class BookclubConfiguration {

    @Bean
    public CommentService commentService(CommentRepository commentRepository) {
        return new CommentServiceImpl(commentRepository);

    }
}
