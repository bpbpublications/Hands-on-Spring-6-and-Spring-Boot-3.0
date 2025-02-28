package com.bpb.hssb.ch5.bookclub.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.bpb.hssb.ch5.bookclub.domain.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByAuthor(String author);

    List<Book> findByTitleOrAuthor(String title, String author);

}
