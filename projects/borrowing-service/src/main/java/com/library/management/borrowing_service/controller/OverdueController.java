package com.library.management.borrowing_service.controller;

import com.library.management.borrowing_service.model.Overdue;
import com.library.management.borrowing_service.service.OverdueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/overdues")
public class OverdueController {

    @Autowired
    private OverdueService overdueService;

    @GetMapping
    public List<Overdue> getAllOverdues() {
        return overdueService.getAllOverdues();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Overdue> getOverdueById(@PathVariable Long id) {
        Overdue overdue = overdueService.getOverdueById(id);
        return overdue != null ? ResponseEntity.ok(overdue) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{loanId}")
    public Overdue createOverdue(@PathVariable Long loanId) {
        return overdueService.saveOverdue(loanId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOverdue(@PathVariable Long id) {
        overdueService.deleteOverdue(id);
        return ResponseEntity.noContent().build();
    }
}
