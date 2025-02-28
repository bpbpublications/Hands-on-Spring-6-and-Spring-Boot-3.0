package com.bpb.hssb.ch8.bookclub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.bpb.hssb.ch8.bookclub.handler.CommentHandler;
import com.bpb.hssb.ch8.bookclub.repository.CommentRepository;
import com.bpb.hssb.ch8.bookclub.service.CommentService;
import com.bpb.hssb.ch8.bookclub.service.CommentServiceImpl;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class BookclubConfiguration {

    @Bean
    public CommentService commentService(CommentRepository commentRepository) {
        return new CommentServiceImpl(commentRepository);

    }

    @Bean
    public CommentHandler commentHandler(CommentService service){
        return new CommentHandler(service);
    }

    @Bean
    public RouterFunction<ServerResponse> commentRoutes(CommentHandler handler) {
        return route()
            .path("/api/comments", builder -> builder
                .GET("", handler::findRecentComments)
                .POST("", handler::createComment)
                .GET("/{id}", handler::findById)
                .DELETE("/{id}", handler::deleteComment))
            .build();
    }
}
