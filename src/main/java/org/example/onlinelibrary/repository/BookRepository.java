package org.example.onlinelibrary.repository;

import org.example.onlinelibrary.model.Book;
import org.example.onlinelibrary.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("""
        SELECT b FROM Book b
        JOIN FETCH b.author a
        WHERE (:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', CAST(:title AS string), '%')))
        AND (:author IS NULL OR LOWER(a.name) LIKE LOWER(CONCAT('%', CAST(:author AS string), '%')))
        AND (:tag IS NULL OR :tag MEMBER OF b.tags)
    """)
    List<Book> searchBooks(@Param("title") String title,
                           @Param("author") String author,
                           @Param("tag") String tag);
}
