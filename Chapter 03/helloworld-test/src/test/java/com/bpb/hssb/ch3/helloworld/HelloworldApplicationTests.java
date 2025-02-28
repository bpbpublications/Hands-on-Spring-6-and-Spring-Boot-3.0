package com.bpb.hssb.ch3.helloworld;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.UseMainMethod;
import org.springframework.context.ApplicationContext;

@SpringBootTest(useMainMethod = UseMainMethod.ALWAYS)
class HelloworldApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void testMain() {
		assertNotNull(applicationContext, "ApplicationContext can't be null");
		assertNotNull(applicationContext.getBean(GreetingService.class), "Can not find GreetingService bean");
	}
}
