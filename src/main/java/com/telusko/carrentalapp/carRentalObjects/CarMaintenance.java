package com.telusko.carrentalapp.carRentalObjects;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Car_Maintenance")
@Getter
@Setter
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
}
