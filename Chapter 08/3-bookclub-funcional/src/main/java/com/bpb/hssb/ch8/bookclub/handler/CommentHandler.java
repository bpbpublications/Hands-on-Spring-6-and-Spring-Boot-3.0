package com.bpb.hssb.ch8.bookclub.handler;

import com.bpb.hssb.ch8.bookclub.domain.Comment;
import com.bpb.hssb.ch8.bookclub.service.CommentService;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

public class CommentHandler {

    private final CommentService commentService;

    public CommentHandler(CommentService commentService) {
        this.commentService = commentService;
    }

    public Mono<ServerResponse> findRecentComments(ServerRequest request) {
        return ServerResponse.ok()
                .body(commentService.findRecentComments().take(10), Comment.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return commentService.findById(id)
                .flatMap(comment -> ServerResponse.ok().bodyValue(comment))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> createComment(ServerRequest request) {
        return request.bodyToMono(Comment.class)
                .flatMap(commentService::createComment)
                .flatMap(savedComment -> 
                    ServerResponse.created(URI.create("/api/comments/" + savedComment.getId()))
                        .bodyValue(savedComment))
                .onErrorResume(e -> ServerResponse.badRequest().build());
    }

    public Mono<ServerResponse> deleteComment(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return commentService.findById(id)
                .flatMap(comment -> commentService.deleteComment(comment)
                        .then(ServerResponse.ok().bodyValue(comment)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}