package com.bpb.hssb.ch8.bookclub.service;

import org.springframework.data.domain.Sort;

import com.bpb.hssb.ch8.bookclub.domain.Comment;
import com.bpb.hssb.ch8.bookclub.repository.CommentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Flux<Comment> findRecentComments() {
        return commentRepository.findAll(Sort.by(Sort.Direction.DESC, "created_at"));
    }

    @Override
    public Mono<Comment> createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Mono<Comment> findById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteComment(Comment comment) {
        return commentRepository.delete(comment);
    }
}
