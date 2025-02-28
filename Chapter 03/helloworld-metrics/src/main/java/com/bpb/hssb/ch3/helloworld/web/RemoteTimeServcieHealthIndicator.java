package com.bpb.hssb.ch3.helloworld.web;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RemoteTimeServcieHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if (isServiceAvailable() == false) {
            return Health.down().withDetail("Error Code", 500).build();
        }
        return Health.up().build();
    }

    private boolean isServiceAvailable() {
        return false;
    }

}
