package com.telusko.carrentalapp.carRentalObjects;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Reservation")

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

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Branches getBranchInfo() {
        return branchInfo;
    }

    public void setBranchInfo(Branches branchInfo) {
        this.branchInfo = branchInfo;
    }

    public Cars getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(Cars carInfo) {
        this.carInfo = carInfo;
    }

    public Customers getCustomersInfo() {
        return customersInfo;
    }

    public void setCustomersInfo(Customers customersInfo) {
        this.customersInfo = customersInfo;
    }
}
