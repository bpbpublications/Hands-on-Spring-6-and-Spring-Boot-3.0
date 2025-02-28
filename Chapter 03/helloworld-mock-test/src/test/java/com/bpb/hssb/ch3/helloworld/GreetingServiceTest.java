package com.bpb.hssb.ch3.helloworld;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @MockBean
    private TimeService remoteTimeService;

    @Test
    void testGreetAM() {

        when(remoteTimeService.isAM()).thenReturn(true);

        assertNotNull(greetingService);
        assertNotNull(greetingService.greet());
        assertTrue(greetingService.greet().contains("Hello world"));
        assertEquals("Hello world, it’s a wonderful morning!", greetingService.greet());

    }

    @Test
    void testGreetPM() {

        when(remoteTimeService.isAM()).thenReturn(false);

        assertNotNull(greetingService);
        assertNotNull(greetingService.greet());
        assertTrue(greetingService.greet().contains("Hello world"));
        assertEquals("Hello world, it’s a wonderful afternoon!", greetingService.greet());

    }
}
