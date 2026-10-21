package org.example.onlinelibrary.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;
    @Column(name="title")
    private String title;
    @Column(name = "edition_date")
    private LocalDate editionDate;
    @ElementCollection
    @CollectionTable(name = "book_tags")
    private Set<String> tags = new HashSet<>();
}
