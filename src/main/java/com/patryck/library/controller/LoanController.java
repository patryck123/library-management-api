package com.patryck.library.controller;
import com.patryck.library.entity.*;
import com.patryck.library.repository.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
@RestController @RequestMapping("/api/loans") @RequiredArgsConstructor
@Tag(name = "Empréstimos", description = "Empréstimos e devoluções")
public class LoanController {
    private final LoanRepository loanRepo;
    private final BookRepository bookRepo;
    @PostMapping @Transactional
    public ResponseEntity<Loan> borrow(@RequestBody Loan loan) {
        Book book = bookRepo.findById(loan.getBook().getId()).orElse(null);
        if (book == null || book.getAvailableCopies() <= 0) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        if (book.getAvailableCopies() == 0) book.setAvailable(false);
        bookRepo.save(book);
        loan.setBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(loanRepo.save(loan));
    }
    @GetMapping public ResponseEntity<List<Loan>> findAll() { return ResponseEntity.ok(loanRepo.findAll()); }
    @GetMapping("/borrower/{email}") public ResponseEntity<List<Loan>> byBorrower(@PathVariable String email) { return ResponseEntity.ok(loanRepo.findByBorrowerEmail(email)); }
    @PatchMapping("/{id}/return") @Transactional
    public ResponseEntity<Loan> returnBook(@PathVariable Long id) {
        return loanRepo.findById(id).map(loan -> {
            loan.setStatus(LoanStatus.RETURNED); loan.setReturnDate(LocalDate.now());
            Book book = loan.getBook(); book.setAvailableCopies(book.getAvailableCopies() + 1); book.setAvailable(true);
            bookRepo.save(book);
            return ResponseEntity.ok(loanRepo.save(loan));
        }).orElse(ResponseEntity.notFound().build());
    }
}
