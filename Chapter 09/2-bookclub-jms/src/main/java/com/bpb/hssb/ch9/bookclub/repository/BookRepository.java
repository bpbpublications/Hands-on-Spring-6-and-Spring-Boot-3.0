package com.bpb.hssb.ch9.bookclub.repository;

import org.springframework.data.repository.CrudRepository;

import com.bpb.hssb.ch9.bookclub.domain.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByAuthor(String author);

    List<Book> findByTitleOrAuthor(String title, String author);

}
