package com.telusko.carrentalapp.carRentalObjects;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Cars")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name="branch_id")
    private Long branchId;

    private String make;
    private String model;
    private Integer year;
    private String color;
    private String licensePlate;
    private String status;
    private Double dailyRentalRate;

    @ManyToOne
    @JoinColumn(name="branch_id", insertable = false, updatable = false)
    private Branches branchInfo;

    public Cars() {
    }

    public Cars(Long carId, Long branchId, String make, String model, String color, String licensePlate, String status, Double dailyRentalRate, Integer year) {
        this.carId = carId;
        this.branchId = branchId;
        this.make = make;
        this.model = model;
        this.color = color;
        this.licensePlate = licensePlate;
        this.status = status;
        this.dailyRentalRate = dailyRentalRate;
        this.year = year;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getDailyRentalRate() {
        return dailyRentalRate;
    }

    public void setDailyRentalRate(Double dailyRentalRate) {
        this.dailyRentalRate = dailyRentalRate;
    }

    public Branches getBranchInfo() {
        return branchInfo;
    }

    public void setBranchInfo(Branches branchInfo) {
        this.branchInfo = branchInfo;
    }
}
