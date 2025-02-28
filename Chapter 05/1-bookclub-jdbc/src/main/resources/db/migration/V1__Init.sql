DROP TABLE book IF EXISTS;
DROP TABLE book_copy IF EXISTS;

CREATE TABLE book (
    book_id INT NOT NULL PRIMARY KEY,
    isbn VARCHAR(255) NOT NULL,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publication_year INT NOT NULL
);

CREATE TABLE book_copy (
    copy_id INT NOT NULL PRIMARY KEY,
    book_id INT NOT NULL,
    is_available BOOLEAN NOT NULL,
    CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES book(book_id)
);