package com.telusko.studentmanagement.studentManagementObjects;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @Column(name="student_id")
    private Long studentId;

    @Column(name="course_id")
    private Long courseId;

    private Date enrollmentDate;

    @ManyToOne
    @JoinColumn(name="student_id",insertable = false,updatable = false)
    private Student StudentInfo;

    @ManyToOne
    @JoinColumn(name="course_id",insertable = false,updatable = false)
    private Course courseInfo;


    public Enrollment() {
    }

    public Enrollment(Long enrollmentId, Long studentId, Long courseId, Date enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
    }

    public Student getStudentInfo() {
        return StudentInfo;
    }

    public void setStudentInfo(Student studentInfo) {
        StudentInfo = studentInfo;
    }

    public Course getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(Course courseInfo) {
        this.courseInfo = courseInfo;
    }

    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
