package com.bpb.hssb.ch3.helloworld.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(HelloController.class)
public class HelloControllerWebMVCTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GreetingService greetingService;

	@Test
	void testHello() throws Exception {
		when(greetingService.greet()).thenReturn("Hello world, it’s a wonderful morning!");
		
		this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello world")));
	}

}
