package com.bpb.hssb.ch3.helloworld.web;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    Logger logger = LoggerFactory.getLogger(GreetingService.class);

    public String greet() {
        LocalTime now = LocalTime.now();
        int currentHour = now.getHour();
        String msg = "Hello world";
        logger.debug("The currrnt hour of the day : {}", currentHour);
        logger.debug("Message prefix : {}", msg);
        if (currentHour < 12) {
            return msg + ", it’s a wonderful morning!";
        } else {
            return msg + ", it’s a wonderful afternoon!";
        }
    }
}
