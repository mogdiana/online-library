package org.example.onlinelibrary.repository;

import org.example.onlinelibrary.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
    @Query("SELECT DISTINCT 1 FROM Library l " +
     "JOIN Stock s "   +
     "JOIN Book b " +
     "JOIN Author a " +
     "WHERE (:bookName IS NULL OR b.title LIKE %:bookName%) " +
     " AND (:author IS NULL OR a.name LIKE %:author%)")
    List<Library> searchLibraries(@Param("bookName") String bookName,
                                  @Param("author") String author);
}
