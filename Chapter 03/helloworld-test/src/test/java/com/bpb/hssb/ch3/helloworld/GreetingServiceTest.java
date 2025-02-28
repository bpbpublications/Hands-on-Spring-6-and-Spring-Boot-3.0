package com.bpb.hssb.ch3.helloworld;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    public void testGreet() {
        assertNotNull(greetingService);
        assertNotNull(greetingService.greet());
        assertTrue(greetingService.greet().contains("Hello world"));
        if (isAM()) {
            assertEquals("Hello world, it’s a wonderful morning!", greetingService.greet());
        } else {
            assertEquals("Hello world, it’s a wonderful afternoon!", greetingService.greet());
        }
    }

    private boolean isAM() {
        if (LocalTime.now().getHour() < 12) {
            return true;
        }
        return false;
    }

}
