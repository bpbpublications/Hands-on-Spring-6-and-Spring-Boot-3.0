package com.bpb.hssb.ch10.bookclub.repository;

import org.springframework.data.repository.CrudRepository;

import com.bpb.hssb.ch10.bookclub.domain.BookCopy;

public interface BookCopyJPARepository extends CrudRepository<BookCopy, Integer>{

}
