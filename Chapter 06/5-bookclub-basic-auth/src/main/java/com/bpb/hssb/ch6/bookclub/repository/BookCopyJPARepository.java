package com.bpb.hssb.ch6.bookclub.repository;

import org.springframework.data.repository.CrudRepository;

import com.bpb.hssb.ch6.bookclub.domain.BookCopy;

public interface BookCopyJPARepository extends CrudRepository<BookCopy, Integer>{

}
