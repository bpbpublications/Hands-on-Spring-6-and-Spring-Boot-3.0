package com.bpb.hssb.ch2.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloworldConfiguration {

    @Bean
    public GreetingService greetingService(@Value("${helloworld.application.subject}") String subject){
        return new GreetingService(subject);
    }

}
