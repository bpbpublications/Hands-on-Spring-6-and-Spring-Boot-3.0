package com.bpb.hssb.ch9.bookclub.repository;

import org.springframework.data.repository.CrudRepository;

import com.bpb.hssb.ch9.bookclub.domain.ReservationRequest;

public interface ReservationRequestRepository extends CrudRepository<ReservationRequest, Integer> {

}
