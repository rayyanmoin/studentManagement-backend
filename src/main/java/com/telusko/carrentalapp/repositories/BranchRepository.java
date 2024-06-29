package com.telusko.carrentalapp.repositories;

import com.telusko.carrentalapp.carRentalObjects.Branches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branches,Long> {
}
