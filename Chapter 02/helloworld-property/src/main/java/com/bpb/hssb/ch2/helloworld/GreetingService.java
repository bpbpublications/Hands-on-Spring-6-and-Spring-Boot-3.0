package com.bpb.hssb.ch2.helloworld;

import java.time.LocalTime;

public class GreetingService {

    private String subject;

    public GreetingService(String subject) {
        this.subject = subject;
    }

    public String greet() {
        String msg = "Hello " + subject;
        LocalTime now = LocalTime.now();
        int currentHour = now.getHour();
        if (currentHour < 12) {
            return msg + ", it’s a wonderful morning!";
        } else {
            return msg + ", it’s a wonderful afternoon!";
        }
    }
}
