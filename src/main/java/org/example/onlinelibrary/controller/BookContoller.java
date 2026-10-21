package org.example.onlinelibrary.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.onlinelibrary.dto.BookDto;
import org.example.onlinelibrary.model.Book;
import org.example.onlinelibrary.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookContoller {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.create(bookDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.update(id, bookDto));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> search(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String tag) {
        return ResponseEntity.ok(bookService.search(title, author, tag));
    }
}
