package com.bpb.hssb.ch8.bookclub.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.bpb.hssb.ch8.bookclub.domain.Comment;

import reactor.core.publisher.Flux;

public interface CommentRepository extends ReactiveCrudRepository<Comment, Integer> {

    Flux<Comment> findAll(Sort sort);

}
