package com.telusko.carrentalapp.controllers;


import com.telusko.carrentalapp.carRentalObjects.*;
import com.telusko.carrentalapp.dto.*;
import com.telusko.carrentalapp.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("carrentalapi")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

@Autowired
private CustomersRepository customersRepository;

    @Autowired
    private EmployeeRepository employeeRepository ;


    @Autowired
    private EmployeeSalaryRepository employeeSalaryRepository;

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

    @GetMapping("/carDropdown/getList")
    public List<CarDropDownDto> getCarDropdown(){
        List<Cars> cars = carsRepository.findAll();
        List<CarDropDownDto> carDropList = new ArrayList<>();
        for(Cars car : cars){
            CarDropDownDto carDropDownDto = new CarDropDownDto();
            carDropDownDto.setCarId(car.getCarId());
            carDropDownDto.setCarName(car.getMake() + " " + car.getModel() + " " + car.getYear());
            carDropDownDto.setDailyRentalRate(car.getDailyRentalRate());
            carDropList.add(carDropDownDto);
        }
        return carDropList;
    }
    @GetMapping("/employee/getList")
    public List<EmployeeListDto> getEmployeeListDto() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeListDto> employeeList = new ArrayList<>();
        for (Employee employee : employees){
            EmployeeListDto employeeListDto = new EmployeeListDto();
            employeeListDto.setEmployeeId(employee.getEmployeeId());
            employeeListDto.setName(employee.getName());
            employeeListDto.setProfession(employee.getProfession());
            employeeListDto.setPhoneNumber(employee.getPhoneNumber());
            employeeListDto.setAddress(employee.getAddress());
            employeeListDto.setBranchName(employee.getBranchInfo().getBranchName());


            employeeList.add(employeeListDto);
        }
        return employeeList;
    }
    @GetMapping("employeeSalary/getList")
    public List<EmployeeSalaryListDto> getEmployeeSalaryListDto(){
        List<EmployeeSalary> employeeSalaries = employeeSalaryRepository.findAll();
        List<EmployeeSalaryListDto> employeeSalaryListDtos = new ArrayList<>();
        for(EmployeeSalary employeeSalary : employeeSalaries){
            EmployeeSalaryListDto employeeSalaryListDto = new EmployeeSalaryListDto();
            employeeSalaryListDto.setSalaryId(employeeSalary.getSalaryId());
            employeeSalaryListDto.setName(employeeSalary.getEmployeeInfo().getName());
            employeeSalaryListDto.setSalaryDate(employeeSalary.getSalaryDate());
            employeeSalaryListDto.setSalaryAmount(employeeSalary.getSalaryAmount());
            employeeSalaryListDto.setPaymentMode(employeeSalary.getPaymentMode());
            employeeSalaryListDto.setChequeNumber(employeeSalary.getChequeNumber());
            employeeSalaryListDto.setPaidBy(employeeSalary.getPaidBy());

            employeeSalaryListDtos.add(employeeSalaryListDto);
        }
        return employeeSalaryListDtos;
    }

    @GetMapping("/customerDropdown/getList")
    public List<CustomerDropdownDto> getCustomerDropdown(){
        List<Customers> customers = customersRepository.findAll();
        List<CustomerDropdownDto> customerDropList = new ArrayList<>();
        for(Customers customer: customers){
            CustomerDropdownDto carDropDownDto = new CustomerDropdownDto();
            carDropDownDto.setCustomerId(customer.getCustomerId());
            carDropDownDto.setFullName(customer.getFullName());
            customerDropList.add(carDropDownDto);
        }
        return customerDropList;
    }

    @GetMapping("/branchDropdown/getList")
    public List<BranchDropdownDto> getBranchDropdown() {
        List<Branches> branches = branchRepository.findAll();
        List<BranchDropdownDto> branchDropList = new ArrayList<>();
        for(Branches branch : branches){
            BranchDropdownDto branchDropdownDto = new BranchDropdownDto();
            branchDropdownDto.setBranchId(branch.getBranchId());
            branchDropdownDto.setBranchName(branch.getBranchName());
            branchDropList.add(branchDropdownDto);
        }
        return branchDropList;
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

    @PostMapping("/customer/add")
    public String addCustomer(@RequestBody CustomerAddDto customerAddDto){
        Customers customers = new Customers();
        customers.setCnic(customerAddDto.getCnic());
        customers.setFullName(customerAddDto.getFullName());
        customers.setEmail(customerAddDto.getEmail());
        customers.setPhoneNumber(customerAddDto.getPhoneNumber());
        customers.setAddress(customerAddDto.getAddress());
        customers.setCreatedAt(customerAddDto.getCreatedAt());
        customersRepository.save(customers);
        return "Customer added Successfully";
    }

    @PostMapping("/cars/add")
    public String addCar(@RequestBody CarsAddDto carsAddDto){
        Cars cars = new Cars();
        cars.setBranchId(carsAddDto.getBranchId());
        cars.setMake(carsAddDto.getMake());
        cars.setModel(carsAddDto.getModel());
        cars.setYear(carsAddDto.getYear());
        cars.setColor(carsAddDto.getColor());
        cars.setLicensePlate(carsAddDto.getLicensePlate());
        cars.setStatus(carsAddDto.getStatus());
        cars.setDailyRentalRate(carsAddDto.getDailyRentalRate());
        carsRepository.save(cars);
        return "Car Add successfully";
    }

    @PostMapping("/carMaintenance/add")
    public String addCarMaintenance(@RequestBody CarMaintenanceAddDto carMaintenanceAddDto){
        CarMaintenance carMaintenance = new CarMaintenance();
        carMaintenance.setCarId(carMaintenanceAddDto.getCarId());
        carMaintenance.setMaintenanceDate(carMaintenanceAddDto.getMaintenanceDate());
        carMaintenance.setDescription(carMaintenanceAddDto.getDescription());
        carMaintenance.setCost(carMaintenanceAddDto.getCost());
        carMaintenance.setStatus(carMaintenanceAddDto.getStatus());
        carMaintenanceRepository.save(carMaintenance);
        return "CarMaintenance Add Successfully";
    }

    @PostMapping("/reservation/add")
    public String addReservation(@RequestBody ReservationAddDto reservationAddDto){
        Reservation reservation = new Reservation();
        reservation.setBranchId(reservationAddDto.getBranchId());
        reservation.setCustomerId(reservationAddDto.getCustomerId());
        reservation.setCarId(reservationAddDto.getCarId());
        reservation.setStartDate(reservationAddDto.getStartDate());
        reservation.setEndDate(reservationAddDto.getEndDate());
        reservation.setTotalCost(reservationAddDto.getTotalCost());
        reservation.setStatus(reservationAddDto.getStatus());
        reservation.setCreatedAt(reservationAddDto.getCreatedAt());
        reservationRepository.save(reservation);
        return "Reservation Added Successfully";
    }

    @PostMapping("/branches/add")
    public String addBranches(@RequestBody BranchAddDto branchAddDto){
        Branches branches = new Branches();
        branches.setBranchName(branchAddDto.getBranchName());
        branches.setLocation(branchAddDto.getLocation());
        branches.setPhoneNumber(branchAddDto.getPhoneNumber());
        branches.setEmail(branchAddDto.getEmail());
        branchRepository.save(branches);
        return "Branch Added Successfully.";
    }

    @PostMapping("/employee/add")
    public String addEmployee(@RequestBody EmployeeAddDto employeeAddDto){
        Employee employee = new Employee();
        employee.setName(employeeAddDto.getName());
        employee.setProfession(employeeAddDto.getProfession());
        employee.setPhoneNumber(employeeAddDto.getPhoneNumber());
        employee.setAddress(employeeAddDto.getAddress());
        employee.setBranchId(employeeAddDto.getBranchId());
        employeeRepository.save(employee);
        return "Employee Added Successfully";

    }
    @PostMapping("/employeeSalary/add")
    public String addEmployeeSalary(@RequestBody EmployeeSalaryAdd employeeSalaryAdd){
        EmployeeSalary employeeSalary = new EmployeeSalary();
        employeeSalary.setEmployeeId(employeeSalaryAdd.getEmployeeId());
        employeeSalary.setSalaryDate(employeeSalaryAdd.getSalaryDate());
        employeeSalary.setSalaryAmount(employeeSalaryAdd.getSalaryAmount());
        employeeSalary.setPaymentMode(employeeSalaryAdd.getPaymentMode());
        employeeSalary.setChequeNumber(employeeSalaryAdd.getChequeNumber());
        employeeSalary.setPaidBy(employeeSalaryAdd.getPaidBy());
        employeeSalaryRepository.save(employeeSalary);
        return "Employee Salary Added Successfully";
    }

}

