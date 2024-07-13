package com.telusko.carrentalapp.controllers;


import com.telusko.carrentalapp.carRentalObjects.*;
import com.telusko.carrentalapp.dto.CarMaintenanceListDto;
import com.telusko.carrentalapp.dto.CarsListDto;
import com.telusko.carrentalapp.dto.ReservationListDto;
import com.telusko.carrentalapp.repositories.*;
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
    private ReservationRepository reservationRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private CarMaintenanceRepository carMaintenanceRepository;

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

    @GetMapping("/reservation/getList")
    public List<ReservationListDto> getReservationList(){
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationListDto> reservationList = new ArrayList<>();
        for(Reservation reservation : reservations){
            ReservationListDto reservationListDto = new ReservationListDto();
            reservationListDto.setReservationId(reservation.getReservationId());
            reservationListDto.setStartDate(reservation.getStartDate());
            reservationListDto.setEndDate(reservation.getEndDate());
            reservationListDto.setTotalCost(reservation.getTotalCost());
            reservationListDto.setStatus(reservation.getStatus());
            reservationListDto.setCreatedAt(reservation.getCreatedAt());
            reservationListDto.setBranchName(reservation.getBranchInfo().getBranchName());
            reservationListDto.setMake(reservation.getCarInfo().getMake());
            reservationListDto.setModel(reservation.getCarInfo().getModel());
            reservationListDto.setYear(reservation.getCarInfo().getYear());
            reservationListDto.setCnic(reservation.getCustomersInfo().getCnic());
            reservationListDto.setFullName(reservation.getCustomersInfo().getFullName());
            reservationList.add(reservationListDto);
        }
        return reservationList;
    }

    @GetMapping("/carMaintenance/getList")
    public List<CarMaintenanceListDto> getCarMaintenanceList() {
        List<CarMaintenance> carMaintenances = carMaintenanceRepository.findAll();
        List<CarMaintenanceListDto> carsMaintenanceList = new ArrayList<>();
        for(CarMaintenance carMaintenance: carMaintenances){

            CarMaintenanceListDto carMaintenanceListDto = new CarMaintenanceListDto();
            carMaintenanceListDto.setMaintenanceId(carMaintenance.getMaintenanceId());
            carMaintenanceListDto.setMaintenanceDate(carMaintenance.getMaintenanceDate());
            carMaintenanceListDto.setDescription(carMaintenance.getDescription());
            carMaintenanceListDto.setCost((carMaintenance.getCost()));
            carMaintenanceListDto.setStatus(carMaintenance.getStatus());
            carMaintenanceListDto.setMake(carMaintenance.getCarInfo().getMake());
            carMaintenanceListDto.setModel(carMaintenance.getCarInfo().getModel());
            carMaintenanceListDto.setYear(carMaintenance.getCarInfo().getYear());
            carsMaintenanceList.add(carMaintenanceListDto);
        }
        return carsMaintenanceList;
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

