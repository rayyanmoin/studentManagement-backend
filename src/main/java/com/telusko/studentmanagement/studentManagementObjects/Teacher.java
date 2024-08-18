package com.telusko.studentmanagement.studentManagementObjects;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "Teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    private String teacherName;
    private String phoneNumber;
    private String experience;
    private String qualification;
    private Long salaryAmount;
    private Date joinedDate;
    private String cnic;

    public Teacher() {
    }

    public Teacher(Long teacherId, String teacherName,String phoneNumber, String experience, String qualification, Long salaryAmount, Date joinedDate, String cnic) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
        this.qualification = qualification;
        this.salaryAmount = salaryAmount;
        this.joinedDate = joinedDate;
        this.cnic = cnic;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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
