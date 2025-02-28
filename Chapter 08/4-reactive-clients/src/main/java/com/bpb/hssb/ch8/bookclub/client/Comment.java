package com.bpb.hssb.ch8.bookclub.client;

import java.time.LocalDateTime;

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
public class Comment {

    private Integer id;
    private int bookId;
    private String username;
    private String description;
    private LocalDateTime createdAt;

}
