package com.telusko.carrentalapp.controllers;


import com.telusko.carrentalapp.carRentalObjects.Branches;
import com.telusko.carrentalapp.carRentalObjects.Customers;
import com.telusko.carrentalapp.repositories.BranchRepository;
import com.telusko.carrentalapp.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("carrentalapi")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

@Autowired
private CustomersRepository customersRepository;

    @Autowired
    private BranchRepository branchRepository;

    @GetMapping("/customers/getList")
    public List<Customers> getCustomersList() {
        List<Customers> customers = customersRepository.findAll();
        return customers;
    }

    @GetMapping("/branches/getList")
    public List<Branches> getBranchList() {
        List<Branches> branches = branchRepository.findAll();
        return branches;
    }

}

