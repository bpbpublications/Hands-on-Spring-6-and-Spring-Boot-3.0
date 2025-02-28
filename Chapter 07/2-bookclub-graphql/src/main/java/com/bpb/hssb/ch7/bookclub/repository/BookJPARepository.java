package com.bpb.hssb.ch7.bookclub.repository;

import org.springframework.data.repository.CrudRepository;

import com.bpb.hssb.ch7.bookclub.domain.Book;

public interface BookJPARepository extends CrudRepository<Book, Integer> {

    Iterable<Book> findByTitleContaining(String titlePart);
    
    Iterable<Book> findByAuthorContainingIgnoreCase(String authorNamePart);

}
