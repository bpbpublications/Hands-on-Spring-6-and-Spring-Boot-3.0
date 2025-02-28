package com.bpb.hssb.ch7.bookclub.domain;

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
public class BookInput {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
}
