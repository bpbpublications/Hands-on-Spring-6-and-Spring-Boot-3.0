package com.bpb.hssb.ch3.helloworld.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    private static Logger log = LoggerFactory.getLogger(HelloController.class);


    private GreetingService greetingService;

    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        log.info("Say Hello  along with trace Id");
        log.info(request.get);

        return greetingService.greet();
    }
}
