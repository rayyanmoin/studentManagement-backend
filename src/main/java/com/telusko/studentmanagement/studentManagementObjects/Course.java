package com.telusko.studentmanagement.studentManagementObjects;

import jakarta.persistence.*;


@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name="teacher_id")
    private Long teacherId;

    private String courseName;
    private Long amount;

    @ManyToOne
    @JoinColumn(name="teacher_id",insertable = false,updatable = false)
    private Teacher teacherInfo;

    public Course() {
    }

    public Course(Long courseId, Long teacherId, String courseName, Long amount) {
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.courseName = courseName;
        this.amount = amount;
    }

    public Teacher getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(Teacher teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
