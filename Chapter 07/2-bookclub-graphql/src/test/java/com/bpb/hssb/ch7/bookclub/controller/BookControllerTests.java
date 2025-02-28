package com.bpb.hssb.ch7.bookclub.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import com.bpb.hssb.ch7.bookclub.domain.Book;
import com.bpb.hssb.ch7.bookclub.service.BookService;
import com.bpb.hssb.ch7.bookclub.service.BookServiceException;

@GraphQlTest(BookController.class)
public class BookControllerTests {

    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private BookService bookService;

    @Test
    void testBookDetails() throws Exception {

        Book book = Book.builder().bookId(1).author("Nisha").title("Java 17")
                .isbn("9789355511263").publicationYear(2022).build();
        when(bookService.getBook(1)).thenReturn(book);

        graphQlTester.documentName("bookDetails")
                .variable("bookId", 1)
                .execute()
                .path("bookById")
                .path("bookById.bookId").entity(Integer.class).isEqualTo(1)
                .path("bookById.isbn").entity(String.class).isEqualTo("9789355511263")
                .path("bookById.title").entity(String.class).isEqualTo("Java 17");

    }

    @Test
    void testCreateBook() throws BookServiceException {

        Map<String, Object> bookInput = Map.of(
                "isbn", "1234567890",
                "title", "Test Book",
                "author", "Test Author",
                "publicationYear", 2023);

        Book createdBook = Book.builder()
                .bookId(1)
                .isbn("1234567890")
                .title("Test Book")
                .author("Test Author")
                .publicationYear(2023)
                .build();

        when(bookService.createBook(any(Book.class))).thenReturn(createdBook);

        graphQlTester.documentName("createBook")
                .variable("book", bookInput)
                .execute()
                .path("createBook")
                .path("createBook.bookId").entity(Integer.class).isEqualTo(1)
                .path("createBook.isbn").entity(String.class).isEqualTo("1234567890")
                .path("createBook.title").entity(String.class).isEqualTo("Test Book")
                .path("createBook.author").entity(String.class).isEqualTo("Test Author")
                .path("createBook.publicationYear").entity(Integer.class).isEqualTo(2023);
    }

}
