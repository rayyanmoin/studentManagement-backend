package com.telusko.carrentalapp.repositories;

import com.telusko.carrentalapp.carRentalObjects.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers,Long> {



}
