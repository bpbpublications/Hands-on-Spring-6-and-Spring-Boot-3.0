package com.bpb.hssb.ch5.bookclub.domain;

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
public class BookCopy {
    
    private int copyId;
    private Book book;
    private boolean isAvailable;

}
