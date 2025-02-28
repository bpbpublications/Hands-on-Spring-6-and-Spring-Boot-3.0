package com.bpb.hssb.ch10.bookclub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bpb.hssb.ch10.bookclub.domain.ServiceInfo;

@Configuration
@Profile("development")
public class DevelopmentConfiguration {

    @Value("${bookclub.service.info.environment}")
    private String environment;

    @Value("${bookclub.service.info.version}")
    private String version;

       @Bean
    public ServiceInfo serviceInfo() {
        return new ServiceInfo(environment, version);
    }

}
