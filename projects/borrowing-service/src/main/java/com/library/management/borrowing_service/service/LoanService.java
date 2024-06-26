package com.library.management.borrowing_service.service;

import com.library.management.borrowing_service.model.Loan;
import com.library.management.borrowing_service.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(Long id) {
        return loanRepository.findById(id).orElse(null);
    }

    public Loan saveLoan(Loan loan) {
        loan.setLoanDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusWeeks(2));  // Example: 2 weeks loan period
        return loanRepository.save(loan);
    }

    public void returnBook(Long id) {
        Loan loan = loanRepository.findById(id).orElse(null);
        if (loan != null) {
            loan.setReturnDate(LocalDate.now());
            loanRepository.save(loan);
        }
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}
