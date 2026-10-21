package org.example.onlinelibrary.service;

import lombok.RequiredArgsConstructor;
import org.example.onlinelibrary.dto.BookDto;
import org.example.onlinelibrary.model.Author;
import org.example.onlinelibrary.model.Book;
import org.example.onlinelibrary.repository.AuthorRepository;
import org.example.onlinelibrary.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public List<BookDto> findAll() {
        return bookRepository.findAll().stream().map(BookDto::from).toList();
    }

    public BookDto findById(Long id) {
        return BookDto.from(getBook(id));
    }

    private Book getBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }

    public BookDto create(BookDto request) {
        Book book = new Book();
        apply(book, request);
        return BookDto.from(bookRepository.save(book));
    }

    public BookDto update(Long id, BookDto bookDto) {
        Book book = getBook(id);
        apply(book, bookDto);
        return BookDto.from(bookRepository.save(book));
    }


    private void apply(Book book, BookDto bookDto) {
        Author author = authorRepository.findById(bookDto.authorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Author not found"));
        book.setTitle(bookDto.title());
        book.setEditionDate(bookDto.editionDate());
        book.setAuthor(author);
        book.getTags().clear();
        if (bookDto.tags() != null) {
            book.getTags().addAll(bookDto.tags());
        }
    }

    public void delete(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        bookRepository.deleteById(id);
    }

    public List<Book> search(String title, String author, String tag) {
        return bookRepository.searchBooks(title, author, tag);
    }

}
