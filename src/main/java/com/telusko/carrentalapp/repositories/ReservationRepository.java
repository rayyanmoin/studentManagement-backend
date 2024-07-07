package com.telusko.carrentalapp.repositories;

import com.telusko.carrentalapp.carRentalObjects.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
