package com.bpb.hssb.ch5.bookclub.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bpb.hssb.ch5.bookclub.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findByBookId(int bookId);
}
