package com.patryck.library.repository;
import com.patryck.library.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByBorrowerEmail(String email);
    List<Loan> findByStatus(LoanStatus status);
    boolean existsByBookIdAndStatus(Long bookId, LoanStatus status);
}
