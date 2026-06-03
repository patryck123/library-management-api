package com.patryck.library.repository;
import com.patryck.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAvailableTrue();
    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByCategory(String category);
    Optional<Book> findByIsbn(String isbn);
}
