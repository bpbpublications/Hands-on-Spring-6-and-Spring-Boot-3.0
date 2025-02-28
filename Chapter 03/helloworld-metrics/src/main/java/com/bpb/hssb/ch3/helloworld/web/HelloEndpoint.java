package com.bpb.hssb.ch3.helloworld.web;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Endpoint(id = "hello")
@Component
public class HelloEndpoint {

    @ReadOperation
    @Bean
    public String hello() {
        return "HelloEndpoint is UP";
    }

}