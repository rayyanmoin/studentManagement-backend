package com.telusko.carrentalapp.repositories;

import com.telusko.carrentalapp.carRentalObjects.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Cars,Long> {
}
