package com.bpb.hssb.ch9.bookclub.service;

import com.bpb.hssb.ch9.bookclub.domain.ReservationRequest;
import com.bpb.hssb.ch9.bookclub.repository.ReservationRequestRepository;

public class ReservationServiceImpl implements ReservationService {

    private ReservationRequestRepository reservationRequestRepository;

    public ReservationServiceImpl(ReservationRequestRepository reservationRequestRepository) {
        this.reservationRequestRepository = reservationRequestRepository;
    }

    @Override
    public ReservationRequest createReservationRequest(ReservationRequest reservationRequest) {
        return reservationRequestRepository.save(reservationRequest);
    }

}
