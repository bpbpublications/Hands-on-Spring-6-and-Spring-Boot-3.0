package com.bpb.hssb.ch8.bookclub.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BookclubConfiguration {

    @Value("${bookclub.api.baseurl}")
    private String baseurl;

    @Bean
    public WebClient webClient() {
        return WebClient.create(baseurl);
    }

}
