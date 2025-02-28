package com.bpb.hssb.ch6.bookclub.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.graphql.client.GraphQlClient;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class BookGraphQlClient implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BookGraphQlClient.class);

	@Autowired
	private GraphQlClient graphQlClient;

	public static void main(String[] args) {
		SpringApplication.run(BookGraphQlClient.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Book book = createBook();
		printBookInfo(book.getBookId());
	}

	public Book createBook() {

		Map<String, Object> bookInput = Map.of(
				"isbn", "9789355511254",
				"title", "Hands on Spring Spring Boot 3",
				"author", "Sagara Gunathunga",
				"publicationYear", 2024);

		Mono<ClientGraphQlResponse> responseMono = graphQlClient.documentName("createBook")
				.variable("book", bookInput)
				.execute();

		ClientGraphQlResponse response = responseMono.block();

		return response.field("createBook").toEntity(Book.class);

	}

	public void printBookInfo(int bookId) {

		Mono<ClientGraphQlResponse> responseMono = graphQlClient.documentName("bookDetails")
				.variable("bookId",bookId)
				.execute();

		ClientGraphQlResponse response = responseMono.block();
		Book book = response.field("bookById").toEntity(Book.class);
		logger.info(" Book : " + book);
	}
}
