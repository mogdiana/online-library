-- Authors (5 entities)
INSERT INTO author (name, birth_date, death_date) VALUES ('Leo Tolstoy', '1828-09-09', '1910-11-20') ON CONFLICT DO NOTHING;
INSERT INTO author (name, birth_date, death_date) VALUES ('Jane Austen', '1775-12-16', '1817-07-18') ON CONFLICT DO NOTHING;
INSERT INTO author (name, birth_date, death_date) VALUES ('Mark Twain', '1835-11-30', '1910-04-21') ON CONFLICT DO NOTHING;
INSERT INTO author (name, birth_date, death_date) VALUES ('George Orwell', '1903-06-25', '1950-01-21') ON CONFLICT DO NOTHING;
INSERT INTO author (name, birth_date, death_date) VALUES ('J.K. Rowling', '1965-07-31', NULL) ON CONFLICT DO NOTHING;

-- Books (5 entities with tags)
INSERT INTO book (author_id, title, edition_date) VALUES (1, 'War and Peace', '1869-01-01') ON CONFLICT DO NOTHING;
INSERT INTO book_tags (book_id, tags) VALUES (currval('book_id_seq'), 'classic') ON CONFLICT DO NOTHING;
INSERT INTO book_tags (book_id, tags) VALUES (currval('book_id_seq'), 'historical') ON CONFLICT DO NOTHING;

INSERT INTO book (author_id, title, edition_date) VALUES (2, 'Pride and Prejudice', '1813-01-28') ON CONFLICT DO NOTHING;
INSERT INTO book_tags (book_id, tags) VALUES (currval('book_id_seq'), 'romance') ON CONFLICT DO NOTHING;
INSERT INTO book_tags (book_id, tags) VALUES (currval('book_id_seq'), 'classic') ON CONFLICT DO NOTHING;

INSERT INTO book (author_id, title, edition_date) VALUES (3, 'Adventures of Huckleberry Finn', '1884-12-10') ON CONFLICT DO NOTHING;
INSERT INTO book_tags (book_id, tags) VALUES (currval('book_id_seq'), 'adventure') ON CONFLICT DO NOTHING;
INSERT INTO book_tags (book_id, tags) VALUES (currval('book_id_seq'), 'satire') ON CONFLICT DO NOTHING;

INSERT INTO book (author_id, title, edition_date) VALUES (4, '1984', '1949-06-08') ON CONFLICT DO NOTHING;
INSERT INTO book_tags (book_id, tags) VALUES (currval('book_id_seq'), 'dystopia') ON CONFLICT DO NOTHING;
INSERT INTO book_tags (book_id, tags) VALUES (currval('book_id_seq'), 'political') ON CONFLICT DO NOTHING;

INSERT INTO book (author_id, title, edition_date) VALUES (5, 'Harry Potter and the Philosopher''s Stone', '1997-06-26') ON CONFLICT DO NOTHING;
INSERT INTO book_tags (book_id, tags) VALUES (currval('book_id_seq'), 'fantasy') ON CONFLICT DO NOTHING;
INSERT INTO book_tags (book_id, tags) VALUES (currval('book_id_seq'), 'adventure') ON CONFLICT DO NOTHING;

-- Libraries (4 entities)
INSERT INTO library (name, address) VALUES ('Central Library', 'Moscow, Russia') ON CONFLICT DO NOTHING;
INSERT INTO library (name, address) VALUES ('City Library', 'London, UK') ON CONFLICT DO NOTHING;
INSERT INTO library (name, address) VALUES ('National Library', 'New York, USA') ON CONFLICT DO NOTHING;
INSERT INTO library (name, address) VALUES ('Public Library', 'Paris, France') ON CONFLICT DO NOTHING;

-- Stocks (5 entities)
INSERT INTO stock (library_id, book_id, quantity, price) VALUES (1, 1, 15, 19.99) ON CONFLICT DO NOTHING;
INSERT INTO stock (library_id, book_id, quantity, price) VALUES (2, 2, 10, 14.50) ON CONFLICT DO NOTHING;
INSERT INTO stock (library_id, book_id, quantity, price) VALUES (3, 3, 8, 12.99) ON CONFLICT DO NOTHING;
INSERT INTO stock (library_id, book_id, quantity, price) VALUES (4, 4, 20, 15.00) ON CONFLICT DO NOTHING;
INSERT INTO stock (library_id, book_id, quantity, price) VALUES (1, 5, 12, 18.75) ON CONFLICT DO NOTHING;

-- Sales (4 entities to test stock)
INSERT INTO sale (library_id, book_id, quantity, date) VALUES (1, 1, 2, CURRENT_TIMESTAMP) ON CONFLICT DO NOTHING;
INSERT INTO sale (library_id, book_id, quantity, date) VALUES (2, 2, 1, CURRENT_TIMESTAMP) ON CONFLICT DO NOTHING;
INSERT INTO sale (library_id, book_id, quantity, date) VALUES (3, 3, 3, CURRENT_TIMESTAMP) ON CONFLICT DO NOTHING;
INSERT INTO sale (library_id, book_id, quantity, date) VALUES (4, 4, 5, CURRENT_TIMESTAMP) ON CONFLICT DO NOTHING;