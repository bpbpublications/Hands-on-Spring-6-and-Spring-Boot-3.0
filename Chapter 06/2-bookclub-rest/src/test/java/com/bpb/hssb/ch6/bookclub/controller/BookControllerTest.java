package com.bpb.hssb.ch6.bookclub.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.bpb.hssb.ch6.bookclub.domain.Book;
import com.bpb.hssb.ch6.bookclub.service.BookService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void testGetBook() throws Exception {

        Book book = Book.builder().bookId(1).author("Nisha").title("Java 17")
                .isbn("9789355511263").publicationYear(2022).build();
        when(bookService.getBook(1)).thenReturn(book);

        this.mockMvc.perform(get("/api/books/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.bookId").value(book.getBookId()))
                .andExpect(jsonPath("$.author").value(book.getAuthor()))
                .andExpect(jsonPath("$.title").value(book.getTitle()))
                .andExpect(jsonPath("$.isbn").value(book.getIsbn()))
                .andExpect(jsonPath("$.publicationYear").value(book.getPublicationYear()));
    }

    @Test
    void testGetBookNotFound() throws Exception {

        when(bookService.getBook(1000)).thenThrow(new NoSuchElementException());

        this.mockMvc.perform(get("/api/books/1000"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Book not found"))
                .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    void testCreateBook() throws Exception {

        Book book = Book.builder().bookId(1).author("Nisha").title("Java 17")
                .isbn("9789355511263").publicationYear(2022).build();
        when(bookService.createBook(any(Book.class))).thenReturn(book);

        String newBookJson = "{"
                + "\"author\": \"Nisha\","
                + "\"title\": \"Java 17\","
                + "\"isbn\": \"9789355511263\","
                + "\"publicationYear\": 2022"
                + "}";

        this.mockMvc.perform(post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newBookJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.author").value("Nisha"))
                .andExpect(jsonPath("$.title").value("Java 17"))
                .andExpect(jsonPath("$.isbn").value("9789355511263"))
                .andExpect(jsonPath("$.publicationYear").value(2022));
    }

    @Test
    void testRemoveBook_Success() throws Exception {
        int bookId = 1;

        doNothing().when(bookService).removeBook(bookId);

        mockMvc.perform(delete("/api/books/{bookId}", bookId))
                .andExpect(status().isOk());

        verify(bookService).removeBook(bookId);
    }

}
