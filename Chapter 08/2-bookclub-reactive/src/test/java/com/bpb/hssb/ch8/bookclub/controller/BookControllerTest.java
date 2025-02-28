package com.bpb.hssb.ch8.bookclub.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;


import com.bpb.hssb.ch8.bookclub.domain.Comment;
import com.bpb.hssb.ch8.bookclub.service.CommentService;

import reactor.core.publisher.Mono;


@WebFluxTest(CommentController.class)
public class BookControllerTest {

        @Autowired
        private WebTestClient webTestClient;

        @MockBean
        private CommentService commentService;

        @Test
        void testGetComment() throws Exception {

                Comment comment = Comment.builder()
                .bookId(1)
                .username("Sagara")
                .description("Very good book")
                .build();

                when(commentService.findById(100)).thenReturn(Mono.just(comment));

                webTestClient.get()
                        .uri("/api/comments/100")
                        .exchange().expectStatus()
                        .isOk()
                        .expectBody(Comment.class)
                        .value(cm -> {
                                assertNotNull(cm);
                                assertEquals(1, cm.getBookId());
                                assertEquals("Sagara", cm.getUsername());
                                assertEquals("Very good book", cm.getDescription());
                });
        }

        @Test
        void testGetCommentNotFound() throws Exception {

                when(commentService.findById(100)).thenReturn(Mono.empty());

                webTestClient.get()
                        .uri("/api/comments/100")
                        .exchange().expectStatus()
                        .isNotFound();
                        
        }

        @Test
        void testCreateComment() throws Exception {

        Comment newComment = Comment.builder()
                .bookId(1)
                .username("Sagara")
                .description("Excellent read!")
                .build();

        Comment savedComment = Comment.builder()
                .id(1)
                .bookId(1)
                .username("Sagara")
                .description("Excellent read!")
                .build();
        

        when(commentService.createComment(any(Comment.class))).thenReturn(Mono.just(savedComment));

        webTestClient.post()
                .uri("/api/comments")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(newComment)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Comment.class)
                .value(comment -> {
                    assertNotNull(comment);
                    assertEquals(1, comment.getBookId());
                    assertEquals("Sagara", comment.getUsername());
                    assertEquals("Excellent read!", comment.getDescription());
                });
        }

        @Test
        void testRemoveComment() throws Exception {
                
                Comment comment = Comment.builder()
                .id(100)
                .bookId(1)
                .username("Sagara")
                .description("Very good book")
                .build();

                when(commentService.findById(100)).thenReturn(Mono.just(comment));
                when(commentService.deleteComment(comment)).thenReturn(Mono.empty());

                webTestClient.delete()
                        .uri("/api/comments/100")
                        .exchange().expectStatus()
                        .isOk()
                        .expectBody(Comment.class)
                        .value(cm -> {
                                assertNotNull(cm);
                                assertEquals(1, cm.getBookId());
                                assertEquals("Sagara", cm.getUsername());
                                assertEquals("Very good book", cm.getDescription());
                });
        
        }
}
