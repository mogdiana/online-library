package org.example.onlinelibrary.service;

import org.example.onlinelibrary.dto.BookDto;
import org.example.onlinelibrary.model.Book;
import org.example.onlinelibrary.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
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

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book update(Long id, Book book) {
        return bookRepository.findById(id)
                .map(currentBook -> {
                    currentBook.setTitle(book.getTitle());
                    currentBook.setAuthor(book.getAuthor());
                    currentBook.setEditionDate(book.getEditionDate());
                    currentBook.setTags(book.getTags());
                    return bookRepository.save(currentBook);
                })
                .orElseThrow(() -> new RuntimeException("Book not found"));
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
