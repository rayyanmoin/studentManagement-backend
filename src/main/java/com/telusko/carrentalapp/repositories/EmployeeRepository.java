package com.telusko.carrentalapp.repositories;

import com.telusko.carrentalapp.carRentalObjects.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
