package com.bpb.hssb.ch9.bookclub.client;

import org.springframework.jms.core.JmsTemplate;

import com.bpb.hssb.ch9.bookclub.domain.ReservationRequest;

public class ReservationRequestSender {

    private JmsTemplate jmsTemplate;

    public ReservationRequestSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(ReservationRequest reservationRequest) {
        jmsTemplate.convertAndSend("bookreservation", reservationRequest);

    }
}
