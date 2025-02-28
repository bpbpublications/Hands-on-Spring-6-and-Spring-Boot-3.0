package com.bpb.hssb.ch9.bookclub.client;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.bpb.hssb.ch9.bookclub.domain.ReservationRequest;

public class ReservationRequestSender {

    private String topicExchangeName;

    private RabbitTemplate rabbitTemplate;

    public ReservationRequestSender(RabbitTemplate rabbitTemplate, String topicExchangeName) {
        this.rabbitTemplate = rabbitTemplate;
        this.topicExchangeName = topicExchangeName;
    }

    public void send(ReservationRequest reservationRequest) {
        rabbitTemplate.convertAndSend(topicExchangeName, "foo.bar.baz", reservationRequest);

    }
}
