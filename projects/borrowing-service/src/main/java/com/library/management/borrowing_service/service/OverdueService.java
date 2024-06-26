package com.library.management.borrowing_service.service;

import com.library.management.borrowing_service.model.Overdue;
import com.library.management.borrowing_service.repository.OverdueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OverdueService {

    @Autowired
    private OverdueRepository overdueRepository;

    @Autowired
    private NotificationService notificationService;

    public List<Overdue> getAllOverdues() {
        return overdueRepository.findAll();
    }

    public Overdue getOverdueById(Long id) {
        return overdueRepository.findById(id).orElse(null);
    }

    public Overdue saveOverdue(Long loanId) {
        Overdue overdue = new Overdue();
        overdue.setLoanId(loanId);
        overdue.setOverdueDate(LocalDate.now());
        Overdue savedOverdue = overdueRepository.save(overdue);
        notificationService.sendOverdueNotification("Book overdue: Loan ID " + savedOverdue.getLoanId() + " is overdue since " + savedOverdue.getOverdueDate());
        return savedOverdue;
    }

    public void deleteOverdue(Long id) {
        overdueRepository.deleteById(id);
    }
}
