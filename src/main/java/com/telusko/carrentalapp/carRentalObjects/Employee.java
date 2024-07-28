package com.telusko.carrentalapp.carRentalObjects;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String name;
    private String profession;
    private String phoneNumber;
    private String address;

    @Column(name="branch_id")
    private Long branchId;

    @ManyToOne
    @JoinColumn(name="branch_id", insertable = false, updatable = false)
    private Branches branchInfo;

    public Branches getBranchInfo() {
        return branchInfo;
    }

    public void setBranchInfo(Branches branchInfo) {
        this.branchInfo = branchInfo;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Employee (){

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
