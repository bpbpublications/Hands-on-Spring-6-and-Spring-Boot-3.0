package com.bpb.hssb.ch9.bookclub.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bpb.hssb.ch9.bookclub.domain.ReservationRequest;

@SpringBootApplication
public class BookclubClientApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BookclubClientApplication.class);

	private ReservationRequestSender sender;

	public BookclubClientApplication(ReservationRequestSender sender) {
		this.sender = sender;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookclubClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ReservationRequest request = ReservationRequest.builder()
				.club("NYC")
				.referenceId("R4551524")
				.book("Master Java17")
				.build();
		sender.send(request);
		logger.info("ReservationRequest request published successfully");
	}
}
