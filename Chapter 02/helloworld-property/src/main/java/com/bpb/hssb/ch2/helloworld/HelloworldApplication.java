package com.bpb.hssb.ch2.helloworld;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import({ HelloworldConfiguration.class })
public class HelloworldApplication implements CommandLineRunner {

	private GreetingService greetingService;

	public HelloworldApplication(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(greetingService.greet());
	}
}
