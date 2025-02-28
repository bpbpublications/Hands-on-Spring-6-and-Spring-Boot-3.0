package com.bpb.hssb.ch5.bookclub.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.bpb.hssb.ch5.bookclub.domain.Comment;
import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void init(){
        mongoTemplate.remove(new Query(), Comment.class);
    }

    @Test
    public void testCreateComment() {

        Comment comment = Comment.builder().bookId(5001).description("Good book").user("Sam").build();
        commentRepository.save(comment);

        Query query = new Query();
        query.addCriteria(Criteria.where("bookId").is(5001));
        List<Comment> foundComment = mongoTemplate.find(query, Comment.class);
        assertThat(foundComment.size()).isEqualTo(1);
    }

    @Test
    public void testFindByBookId() {

        Comment comment = Comment.builder().bookId(5001).description("Good book").user("Sam").build();
        mongoTemplate.save(comment);
        
        List<Comment> foundComments = commentRepository.findByBookId(comment.getBookId());
        assertThat(foundComments.size()).isEqualTo(1);
        assertThat(foundComments.get(0).getDescription()).isEqualTo(comment.getDescription());
        assertThat(foundComments.get(0).getUser()).isEqualTo(comment.getUser());

    }

}
