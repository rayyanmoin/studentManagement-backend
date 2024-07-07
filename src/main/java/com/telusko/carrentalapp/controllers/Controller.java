package com.telusko.carrentalapp.controllers;


import com.telusko.carrentalapp.carRentalObjects.Branches;
import com.telusko.carrentalapp.carRentalObjects.Cars;
import com.telusko.carrentalapp.carRentalObjects.Customers;
import com.telusko.carrentalapp.dto.CarsListDto;
import com.telusko.carrentalapp.repositories.BranchRepository;
import com.telusko.carrentalapp.repositories.CarsRepository;
import com.telusko.carrentalapp.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("carrentalapi")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

@Autowired
private CustomersRepository customersRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private CarsRepository carsRepository;

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

    @GetMapping("/cars/getList")
    public List<CarsListDto> getCarsList() {
        List<Cars> cars = carsRepository.findAll();
        List<CarsListDto> carsList = new ArrayList<>();
        for(Cars car: cars){
            CarsListDto carsListDto = new CarsListDto();
            carsListDto.setCarId(car.getCarId());
            carsListDto.setBranchName(car.getBranchInfo().getBranchName());
            carsListDto.setColor(car.getColor());
            carsListDto.setMake(car.getMake());
            carsListDto.setModel(car.getModel());
            carsListDto.setYear(car.getYear());
            carsListDto.setLicensePlate(car.getLicensePlate());
            carsListDto.setStatus(car.getStatus());
            carsListDto.setDailyRentalRate(car.getDailyRentalRate());
            carsList.add(carsListDto);
        }
        return carsList;
    }

}

