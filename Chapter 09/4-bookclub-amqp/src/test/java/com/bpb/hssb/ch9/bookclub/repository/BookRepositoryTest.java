package com.bpb.hssb.ch9.bookclub.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bpb.hssb.ch9.bookclub.domain.Book;

import jakarta.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void testCreateBook() {

        Book book = Book.builder().isbn("9789355511260").title("Spring Testing")
                .author("SpringTeam").publicationYear(2022).build();
        bookRepository.save(book);

        entityManager.flush();
        entityManager.clear();
        Book foundBook = entityManager.find(Book.class, book.getBookId());
        assertThat(foundBook).isNotNull();
        assertThat(foundBook.getTitle()).isEqualTo(book.getTitle());
        assertThat(foundBook.getIsbn()).isEqualTo(book.getIsbn());
        assertThat(foundBook.getAuthor()).isEqualTo(book.getAuthor());
        assertThat(foundBook.getPublicationYear()).isEqualTo(book.getPublicationYear());
    }

    @Test
    public void testGetBook() {

        entityManager.flush();
        entityManager.clear();
        Book book = Book.builder().isbn("9789355511260").title("Spring Testing")
                .author("SpringTeam").publicationYear(2022).build();
        entityManager.persist(book);

        Book foundBook = bookRepository.findById(book.getBookId()).get();
        assertThat(foundBook).isNotNull();
        assertThat(book.getTitle()).isEqualTo(foundBook.getTitle());
        assertThat(book.getIsbn()).isEqualTo(foundBook.getIsbn());
        assertThat(book.getAuthor()).isEqualTo(foundBook.getAuthor());
        assertThat(book.getPublicationYear()).isEqualTo(foundBook.getPublicationYear());
    }

}
