package com.bpb.hssb.ch3.helloworld.web;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerMockTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testHello() throws Exception {
		this.mockMvc.perform(get("/hello")).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello world")));
	}

}
