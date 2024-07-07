package com.telusko.carrentalapp.carRentalObjects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Reservation")
@Getter
@Setter

public class Reservation {
    @Id
    private Long reservationId;


    @Column(name="customer_id")
    private Long customerId;

    @Column(name="car_id")
    private Long carId;

    @Column(name="branch_id")
    private Long branchId;


    private Date startDate;
    private Date endDate;
    private Double totalCost;
    private String status;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name="branch_id", insertable = false, updatable = false)
    private Branches branchInfo;

    @ManyToOne
    @JoinColumn(name="car_id",insertable = false,updatable = false)
    private Cars carInfo;

    @ManyToOne
    @JoinColumn(name="customer_id",insertable = false,updatable = false)
    private Customers customersInfo;

    public Reservation() {
    }

    public Reservation(Long reservationId, Date createdAt, Date endDate, Date startDate, Long branchId, Long carId, Long customerId, String status, Double totalCost) {
        this.reservationId = reservationId;
        this.createdAt = createdAt;
        this.endDate = endDate;
        this.startDate = startDate;
        this.branchId = branchId;
        this.carId = carId;
        this.customerId = customerId;
        this.status = status;
        this.totalCost = totalCost;
    }
}
