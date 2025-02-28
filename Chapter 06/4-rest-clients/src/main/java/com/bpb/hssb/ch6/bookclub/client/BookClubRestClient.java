package com.bpb.hssb.ch6.bookclub.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class BookClubRestClient implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BookClubRestClient.class);

	@Autowired
	private RestClient restClient;



	public static void main(String[] args) {
		SpringApplication.run(BookClubRestClient.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Book book = createBook();
		printBookInfo(book.getBookId());
	}

	private void printBookInfo(int bookId) {
		
		Book book = restClient.get()
				.uri("/books/{bookId}", bookId)
				.retrieve()
				.body(Book.class);

		logger.info("Book details : {}", book);
	}

	public Book createBook() {

		Book book = Book.builder()
				.title("Hands on Spring and Spring Boot 3")
				.author("Sagara Gunathunga")
				.isbn("9789355511232")
				.publicationYear(2024)
				.build();

		return restClient.post()
				.uri("/books")
				.contentType(MediaType.APPLICATION_JSON)
				.body(book)
				.retrieve()
				.toEntity(Book.class)
				.getBody();
	}
}
