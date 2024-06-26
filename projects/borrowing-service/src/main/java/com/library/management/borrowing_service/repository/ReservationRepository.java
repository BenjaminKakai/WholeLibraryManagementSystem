package com.library.management.borrowing_service.repository;

import com.library.management.borrowing_service.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Custom query methods can be defined here
}
