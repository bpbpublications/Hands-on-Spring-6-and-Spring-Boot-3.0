package com.bpb.hssb.ch8.bookclub.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BookClubReactiveClient implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BookClubReactiveClient.class);

	@Autowired
	private WebClient webClient;

	public static void main(String[] args) {
		SpringApplication.run(BookClubReactiveClient.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Comment> comments = webClient.get()
				.uri("/comments")
				.retrieve()
				.bodyToFlux(Comment.class)
				.collectList()
				.block();

		logger.info("Recent Comments : {}", comments);

	}

}
