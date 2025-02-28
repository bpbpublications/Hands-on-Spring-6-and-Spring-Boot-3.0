package com.bpb.hssb.ch6.bookclub.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class BookClubRestTemplateClient implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BookClubRestClient.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${bookclub.api.baseurl}")
    private String baseurl;

	public static void main(String[] args) {
		SpringApplication.run(BookClubRestClient.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Book book = createBook();
		printBookInfo(book.getBookId());
	}

	private void printBookInfo(int bookId) {
		Book book = restTemplate.getForObject(baseurl + "/books/{bookId}", Book.class, bookId);
		logger.info("Book details : " + book);
	}

	public Book createBook() {

		String bookStoreUrl = baseurl + "/books";
		Book book = Book.builder()
				.title("Hands on Spring and Spring Boot 3")
				.author("Sagara Gunathunga")
				.isbn("9789355511232")
				.publicationYear(2024)
				.build();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Book> request = new HttpEntity<>(book, headers);
		ResponseEntity<Book> response = restTemplate.postForEntity(bookStoreUrl, request, Book.class);

		if (response.getStatusCode() == HttpStatus.CREATED) {
			return response.getBody();
		} else {
			throw new RuntimeException("Failed to create book. Status code: " + response.getStatusCode());
		}
	}
}
