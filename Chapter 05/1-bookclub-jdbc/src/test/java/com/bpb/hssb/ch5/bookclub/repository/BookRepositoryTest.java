package com.bpb.hssb.ch5.bookclub.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bpb.hssb.ch5.bookclub.config.BookclubConfiguration;
import com.bpb.hssb.ch5.bookclub.domain.Book;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import({ BookclubConfiguration.class })
class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void testCreateBook() {

		Book book = Book.builder().isbn("9789355511260").title("Spring Testing")
				.author("SpringTeam").publicationYear(2022).build();
		bookRepository.saveBook(book);

		String sql = "SELECT COUNT(*) FROM book WHERE isbn = ? AND title = ?";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class, book.getIsbn(), book.getTitle());
		assertThat(count).isEqualTo(1);
	}

	@Test
	void testGetBook() {

		jdbcTemplate.execute(
				"INSERT INTO book (book_id, isbn, title, author, publication_year) VALUES  (2001,'9789355511273','Java Testing','SpringTeam',2022)");

		Book book = bookRepository.findBookById(2001);
		assertThat(book).isNotNull();
		assertThat(book.getBookId()).isEqualTo(2001);
		assertThat(book.getIsbn()).isEqualTo("9789355511273");
		assertThat(book.getTitle()).isEqualTo("Java Testing");
		assertThat(book.getAuthor()).isEqualTo("SpringTeam");
		assertThat(book.getPublicationYear()).isEqualTo(2022);
	}

	@Test
	void testDeleteBook() {

		jdbcTemplate.execute(
				"INSERT INTO book (book_id, isbn, title, author, publication_year) VALUES  (2001,'9789355511273','Java Testing','SpringTeam',2022)");

		bookRepository.deleteBook(2001);

		String sql = "SELECT COUNT(*) FROM book WHERE book_id = ?";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class, 2001);
		assertThat(count).isEqualTo(0);
	}

}
