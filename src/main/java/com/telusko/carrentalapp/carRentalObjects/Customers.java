package com.telusko.carrentalapp.carRentalObjects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "Customers")

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

 public Long getCustomerId() {
  return customerId;
 }

 public void setCustomerId(Long customerId) {
  this.customerId = customerId;
 }

 public String getCnic() {
  return cnic;
 }

 public void setCnic(String cnic) {
  this.cnic = cnic;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getFullName() {
  return fullName;
 }

 public void setFullName(String fullName) {
  this.fullName = fullName;
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

 public Date getCreatedAt() {
  return createdAt;
 }

 public void setCreatedAt(Date createdAt) {
  this.createdAt = createdAt;
 }
}
