package com.library.management.borrowing_service.repository;

import com.library.management.borrowing_service.model.Overdue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OverdueRepository extends JpaRepository<Overdue, Long> {
    // Custom query methods can be defined here
}
