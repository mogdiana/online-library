package org.example.onlinelibrary.dto;

import org.example.onlinelibrary.model.Book;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public record BookDto(int id, String title, LocalDate editionDate,
                      String authorName, Set<String> tags) {
    public static BookDto from(Book b) {
        return new BookDto(b.getId(), b.getTitle(), b.getEditionDate(),
                b.getAuthor().getName(), new HashSet<>(b.getTags()));
    }
}