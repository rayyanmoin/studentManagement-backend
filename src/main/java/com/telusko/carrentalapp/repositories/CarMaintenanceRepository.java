package com.telusko.carrentalapp.repositories;

import com.telusko.carrentalapp.carRentalObjects.CarMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarMaintenanceRepository extends JpaRepository<CarMaintenance,Long> {
}
