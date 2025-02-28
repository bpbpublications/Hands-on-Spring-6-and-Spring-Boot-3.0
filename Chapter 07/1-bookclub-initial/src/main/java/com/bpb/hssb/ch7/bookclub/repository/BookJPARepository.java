package com.bpb.hssb.ch7.bookclub.repository;

import org.springframework.data.repository.CrudRepository;

import com.bpb.hssb.ch7.bookclub.domain.Book;

public interface BookJPARepository extends CrudRepository<Book, Integer> {
    
    public Iterable<Book> findByTitleContaining(String titlePart);
    
    public Iterable<Book> findByAuthorContainingIgnoreCase(String authorNamePart);

}
