package com.patryck.library.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
@Entity @Table(name = "books") @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @NotBlank @Column(nullable = false) private String title;
    @NotBlank @Column(nullable = false) private String author;
    @Column(unique = true) private String isbn;
    private String category;
    private Integer year;
    @Builder.Default private Integer totalCopies = 1;
    @Builder.Default private Integer availableCopies = 1;
    @Builder.Default private Boolean available = true;
}
