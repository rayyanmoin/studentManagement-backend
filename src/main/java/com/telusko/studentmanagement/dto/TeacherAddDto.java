package com.telusko.studentmanagement.dto;

import java.util.Date;

public class TeacherAddDto {

    private String teacherName;
    private String phoneNumber;
    private String experience;
    private String qualification;
    private Long salaryAmount;
    private Date joinedDate;
    private String cnic;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Long getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(Long salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }
}
