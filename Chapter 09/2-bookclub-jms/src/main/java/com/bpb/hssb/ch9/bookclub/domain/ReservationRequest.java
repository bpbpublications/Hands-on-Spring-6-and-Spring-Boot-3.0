package com.bpb.hssb.ch9.bookclub.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class ReservationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reservationId;
    private String referenceId;
    private String club;
    private String book;

}
