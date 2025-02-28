package com.bpb.hssb.ch8.bookclub.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bpb.hssb.ch8.bookclub.domain.Comment;
import com.bpb.hssb.ch8.bookclub.service.CommentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {

        this.commentService = commentService;
    }

    @GetMapping
    public Flux<Comment> findRecentComments() {

        return commentService.findRecentComments()
                .take(10)
                .switchIfEmpty(Flux.empty());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Comment>> findById(@PathVariable int id) {

        return commentService.findById(id)
                .map(comment -> ResponseEntity.ok(comment))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Comment>> createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment)
                .map(savedComment -> ResponseEntity
                        .created(URI.create("/api/comments/" + savedComment.getId()))
                        .body(savedComment))
                .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().build()));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Comment>> deleteComment(@PathVariable int id) {

        return commentService.findById(id).flatMap(
                comment -> commentService.deleteComment(comment).then(Mono.just(ResponseEntity.ok(comment))))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
