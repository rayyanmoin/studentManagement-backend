package com.telusko.carrentalapp.dto;

public class CarDropDownDto {

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Double getDailyRentalRate() {
        return dailyRentalRate;
    }

    public void setDailyRentalRate(Double dailyRentalRate) {
        this.dailyRentalRate = dailyRentalRate;
    }

    private Long carId;
    private String carName;
    private Double dailyRentalRate;


}
