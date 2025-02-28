package com.bpb.hssb.ch3.helloworld;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    private TimeService timeService;

    public GreetingService(TimeService timeService) {
        this.timeService = timeService;
    }

    public String greet() {
        String msg = "Hello world";
        if (timeService.isAM()) {
            return msg + ", it’s a wonderful morning!";
        } else {
            return msg + ", it’s a wonderful afternoon!";
        }
    }
}
