package com.bpb.hssb.ch2.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloworldConfiguration {

    @Bean
    public GreetingService greetingService() {
        return new GreetingService();
    }

}
