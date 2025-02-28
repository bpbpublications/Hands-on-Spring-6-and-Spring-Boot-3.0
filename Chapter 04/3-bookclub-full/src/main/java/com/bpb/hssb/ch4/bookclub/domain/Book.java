package com.bpb.hssb.ch4.bookclub.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    private String bookId;
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private List<BookCopy> copies;

}
