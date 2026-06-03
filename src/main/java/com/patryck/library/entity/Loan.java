package com.patryck.library.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity @Table(name = "loans") @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Loan {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "book_id") private Book book;
    @Column(nullable = false) private String borrowerName;
    @Column(nullable = false) private String borrowerEmail;
    @Column(nullable = false) private LocalDate loanDate;
    @Column(nullable = false) private LocalDate dueDate;
    private LocalDate returnDate;
    @Enumerated(EnumType.STRING) @Builder.Default private LoanStatus status = LoanStatus.ACTIVE;
    @PrePersist protected void onCreate() { loanDate = LocalDate.now(); dueDate = LocalDate.now().plusDays(14); }
}
