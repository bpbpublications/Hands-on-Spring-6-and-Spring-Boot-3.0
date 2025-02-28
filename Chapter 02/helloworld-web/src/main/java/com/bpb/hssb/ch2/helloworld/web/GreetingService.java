package com.bpb.hssb.ch2.helloworld.web;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    public String greet() {
        LocalTime now = LocalTime.now();
        int currentHour = now.getHour();
        String msg = "Hello world";
        if (currentHour < 12) {
            return msg + ", it’s a wonderful morning!";
        } else {
            return msg + ", it’s a wonderful afternoon!";
        }
    }
}
