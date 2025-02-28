package com.bpb.hssb.ch9.bookclub.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int copyId;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    private boolean isAvailable;

}
