package com.bpb.hssb.ch2.helloworld;

import java.time.LocalTime;

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
