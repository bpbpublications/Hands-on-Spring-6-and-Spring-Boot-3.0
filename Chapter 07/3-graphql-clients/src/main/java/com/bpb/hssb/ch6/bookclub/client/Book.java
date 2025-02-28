package com.bpb.hssb.ch6.bookclub.client;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {

    private int bookId;
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
}
