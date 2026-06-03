package com.patryck.library.controller;
import com.patryck.library.entity.Book;
import com.patryck.library.repository.BookRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/books") @RequiredArgsConstructor
@Tag(name = "Livros", description = "Acervo da biblioteca")
public class BookController {
    private final BookRepository repo;
    @PostMapping public ResponseEntity<Book> create(@Valid @RequestBody Book book) { return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(book)); }
    @GetMapping public ResponseEntity<List<Book>> findAll() { return ResponseEntity.ok(repo.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<Book> findById(@PathVariable Long id) { return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @GetMapping("/available") public ResponseEntity<List<Book>> findAvailable() { return ResponseEntity.ok(repo.findByAvailableTrue()); }
    @GetMapping("/search/title") public ResponseEntity<List<Book>> searchByTitle(@RequestParam String q) { return ResponseEntity.ok(repo.findByTitleContainingIgnoreCase(q)); }
    @GetMapping("/search/author") public ResponseEntity<List<Book>> searchByAuthor(@RequestParam String q) { return ResponseEntity.ok(repo.findByAuthorContainingIgnoreCase(q)); }
    @GetMapping("/category/{cat}") public ResponseEntity<List<Book>> byCategory(@PathVariable String cat) { return ResponseEntity.ok(repo.findByCategory(cat)); }
    @PutMapping("/{id}") public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book b) { b.setId(id); return repo.existsById(id) ? ResponseEntity.ok(repo.save(b)) : ResponseEntity.notFound().build(); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { if (!repo.existsById(id)) return ResponseEntity.notFound().build(); repo.deleteById(id); return ResponseEntity.noContent().build(); }
}
