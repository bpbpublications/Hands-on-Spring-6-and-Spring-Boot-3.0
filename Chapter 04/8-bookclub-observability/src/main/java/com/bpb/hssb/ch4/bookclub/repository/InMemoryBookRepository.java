package com.bpb.hssb.ch4.bookclub.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import com.bpb.hssb.ch4.bookclub.domain.Book;
import com.bpb.hssb.ch4.bookclub.domain.BookCopy;

public class InMemoryBookRepository implements BookRepository {

    private static final String BOOK_ID_PREFIX = "BBB";

    private Map<String, Book> books = new HashMap<>();

    public InMemoryBookRepository() {
        populateBookData();
    }

    @Override
    public Book createBook(Book book) {
        String bookId = getBookId();
        book.setBookId(bookId);
        book.setCopies(new ArrayList<>());
        return books.put(bookId, book);
    }

    @Override
    public Book getBook(String bookID) {
        return books.get(bookID);
    }

    @Override
    public Collection<Book> getAllBooks() {
        return books.values();
    }

    @Override
    public Book deleteBook(String bookID) {
        return books.remove(bookID);
    }

    @Override
    public BookCopy createBookCopy(Book book) {
        if (book == null) {
            return null;
        }
        
        return Stream.of(book)
                .map(b -> BookCopy.builder()
                        .book(b)
                        .copyId(getBookCopyId(b))
                        .isAvailable(true)
                        .build())
                .peek(copy -> book.getCopies().add(copy))
                .findFirst()
                .orElse(null);
    }

    @Override
    public BookCopy deleteBookCopy(String bookID, String copyID) {
        Book book = books.get(bookID);
        if (book != null) {
            return book.getCopies().stream()
                    .filter(copy -> copy.getCopyId().equals(copyID))
                    .findFirst()
                    .map(copy -> {
                        book.getCopies().remove(copy);
                        return copy;
                    })
                    .orElse(null);
        }
        return null;
    }

    @Override
    public BookCopy getBookCopy(String bookCopyID) {
        throw new UnsupportedOperationException("Unimplemented method 'getBookCopy'");
    }

    private String getBookId() {
        return BOOK_ID_PREFIX + getRandom();
    }

    private int getRandom() {
        return (int) (Math.random() * (10000 - 100 + 1)) + 100;
    }

    private synchronized String getBookCopyId(Book book) {
        return String.format("%s-%d", book.getBookId(), book.getCopies().size() + 1);

    }

    private void populateBookData() {

        Book bookBB1 = Book.builder().bookId("BBB1").author("Nisha Parameswaran")
                .title("Mastering Java Persistence API").copies(new ArrayList<>())
                .publicationYear(2022)
                .isbn("9789355511263").build();
        bookBB1.getCopies().add(BookCopy.builder().book(bookBB1).copyId("BBB1-1").isAvailable(false).build());
        bookBB1.getCopies().add(BookCopy.builder().book(bookBB1).copyId("BBB1-2").isAvailable(true).build());
        bookBB1.getCopies().add(BookCopy.builder().book(bookBB1).copyId("BBB1-3").isAvailable(true).build());
        books.put("BBB1", bookBB1);

        books.put("BBB2", Book.builder().bookId("BBB2").author("Muneer Ahmad").title("JAVA Programming Simplified")
                .publicationYear(2020).isbn("9789389845143").copies(new ArrayList<>()).build());

        books.put("BBB3",
                Book.builder().bookId("BBB3").author("Lalit Mehra")
                        .title("Software Design Patterns for Java Developers")
                        .publicationYear(2021).isbn("9789391392475").copies(new ArrayList<>()).build());

        books.put("BBB4", Book.builder().bookId("BBB4").author("Ockert Preez").title("JavaScript for Gurus")
                .publicationYear(2020).isbn("9789389423655").copies(new ArrayList<>()).build());

        books.put("BBB5",
                Book.builder().bookId("BBB5").author("Sujit Kumar").title("Fundamentals of Android App Developmen")
                        .publicationYear(2021).isbn("9789389845204").copies(new ArrayList<>()).build());

        books.put("BBB6", Book.builder().bookId("BBB6").author("Pallavi Sharma").title("Selenium with Java")
                .publicationYear(2022).isbn("9789391392680").copies(new ArrayList<>()).build());

    }

}
