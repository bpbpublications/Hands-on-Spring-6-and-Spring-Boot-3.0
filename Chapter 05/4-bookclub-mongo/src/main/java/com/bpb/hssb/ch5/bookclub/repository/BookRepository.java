package com.bpb.hssb.ch5.bookclub.repository;

import org.springframework.data.repository.CrudRepository;

import com.bpb.hssb.ch5.bookclub.domain.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
