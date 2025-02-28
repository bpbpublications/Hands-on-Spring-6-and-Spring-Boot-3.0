package com.bpb.hssb.ch8.bookclub.service;

import com.bpb.hssb.ch8.bookclub.domain.Comment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommentService {

    Flux<Comment> findRecentComments();

    Mono<Comment> createComment(Comment comment);

    Mono<Comment> findById(int id);

    Mono<Void> deleteComment(Comment comment);

}
