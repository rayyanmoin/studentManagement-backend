package com.telusko.studentmanagement.dto;

import java.util.List;

public class StudentAddDto {

    private String studentName;
    private String email;
    private String phoneNumber;
    private String address;
    private List<EnrollmentDto> courses;

    public List<EnrollmentDto> getCourses() {
        return courses;
    }

    public void setCourses(List<EnrollmentDto> courses) {
        this.courses = courses;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
