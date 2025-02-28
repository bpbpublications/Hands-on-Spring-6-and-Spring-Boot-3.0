INSERT INTO
    book (isbn, title, author, publication_year)
VALUES
    ('9789355511263','Mastering Java Persistence API','Nisha Parameswaran',2022),
    ('9789389845143','JAVA Programming Simplified', 'Muneer Ahmad',2020 ),
    ('9789391392475','Software Design Patterns for Java Developers','Lalit Mehra', 2022),
    ('9789389423655','JavaScript for Gurus','Ockert Preez',2022),
    ('9789389845204','Fundamentals of Android App Development','Sujit Kumar',2022),
    ('9789389845209','Fundamentals of iOs App Development','Lalit Kumar',2022);

INSERT INTO
    book_copy (book_id, is_available)
VALUES
    (1, true),
    (1, true),
    (1, true),
    (2, true),
    (2, true);

