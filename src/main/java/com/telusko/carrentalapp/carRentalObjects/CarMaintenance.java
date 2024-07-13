package com.telusko.carrentalapp.carRentalObjects;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Car_Maintenance")
public class CarMaintenance {

    @Id
    private Long maintenanceId;
    @Column(name="car_id")
    private Long carId;

    private Date maintenanceDate;
    private String description;
    private Double cost;
    private String status;

    @ManyToOne
    @JoinColumn(name="car_id",insertable = false,updatable = false)
    private Cars carInfo;

    public CarMaintenance() {
    }

    public CarMaintenance(Long maintenanceId, Long carId, Date maintenanceDate, String description, Double cost, String status) {
        this.maintenanceId = maintenanceId;
        this.carId = carId;
        this.maintenanceDate = maintenanceDate;
        this.description = description;
        this.cost = cost;
        this.status = status;
    }

    public Long getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Long maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Cars getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(Cars carInfo) {
        this.carInfo = carInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
