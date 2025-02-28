package com.bpb.hssb.ch8.bookclub.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

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

    @Id
    private Integer id;
    private int bookId;
    private String username;
    private String description;
    private LocalDateTime createdAt;

}
