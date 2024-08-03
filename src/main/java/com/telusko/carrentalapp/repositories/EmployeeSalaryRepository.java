package com.telusko.carrentalapp.repositories;

import com.telusko.carrentalapp.carRentalObjects.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary,Long> {
}
