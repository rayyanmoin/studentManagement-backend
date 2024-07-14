package com.telusko.carrentalapp.dto;

public class CarsAddDto {

    private Long branchId;

    private String make;
    private String model;
    private Integer year;
    private String color;
    private String licensePlate;
    private String status;
    private Double dailyRentalRate;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
