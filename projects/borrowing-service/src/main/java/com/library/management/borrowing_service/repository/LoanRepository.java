package com.library.management.borrowing_service.repository;

import com.library.management.borrowing_service.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    // Custom query methods can be defined here
}
