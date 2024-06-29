package com.telusko.carrentalapp.carRentalObjects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Branches")
@Getter
@Setter
public class Branches {
    @Id
    private Long branchId;
    private String branchName;
    private String location;
    private String phoneNumber;
    private String email;

    public Branches() {
    }

    public Branches(Long branchId, String branchName, String location, String phoneNumber, String email) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
