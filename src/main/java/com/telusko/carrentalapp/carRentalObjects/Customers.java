package com.telusko.carrentalapp.carRentalObjects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "Customers")
@Getter
@Setter
public class Customers {

 @Id
 private Long customerId;
 private String cnic;
 private String fullName;
 private String email;
 private String phoneNumber;
 private String address;
 private Date createdAt;

 public Customers() {
 }

 public Customers(Long customerId, String cnic, String fullName, String email, String phoneNumber, String address, Date createdAt) {
  this.customerId = customerId;
  this.cnic = cnic;
  this.fullName = fullName;
  this.email = email;
  this.phoneNumber = phoneNumber;
  this.address = address;
  this.createdAt = createdAt;
 }
}
