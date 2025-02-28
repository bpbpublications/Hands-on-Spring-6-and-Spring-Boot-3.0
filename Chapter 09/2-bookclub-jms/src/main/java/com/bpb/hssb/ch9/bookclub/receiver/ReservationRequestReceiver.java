package com.bpb.hssb.ch9.bookclub.receiver;

import org.springframework.jms.annotation.JmsListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bpb.hssb.ch9.bookclub.domain.ReservationRequest;
import com.bpb.hssb.ch9.bookclub.service.ReservationService;
import com.bpb.hssb.ch9.bookclub.service.ReservationServiceImpl;

public class ReservationRequestReceiver {

    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);

    private ReservationService reservationService;

    public ReservationRequestReceiver(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @JmsListener(destination = "bookreservation", containerFactory = "myFactory")
    public void receiveMessage(ReservationRequest reservationRequest) {
        ReservationRequest created = reservationService.createReservationRequest(reservationRequest);
        logger.info("ReservationRequest created : " + created);
    }
}
