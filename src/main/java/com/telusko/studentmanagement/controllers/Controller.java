package com.telusko.studentmanagement.controllers;
import com.telusko.studentmanagement.dto.CourseDto;
import com.telusko.studentmanagement.dto.StudentDto;
import com.telusko.studentmanagement.dto.TeacherDto;
import com.telusko.studentmanagement.repositories.CourseRepository;
import com.telusko.studentmanagement.repositories.EnrollmentRepository;
import com.telusko.studentmanagement.repositories.StudentRepository;
import com.telusko.studentmanagement.repositories.TeacherRepository;
import com.telusko.studentmanagement.studentManagementObjects.Course;
import com.telusko.studentmanagement.studentManagementObjects.Student;
import com.telusko.studentmanagement.studentManagementObjects.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("studentmanagementapi")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;



    @GetMapping("/course/getList")
    public List<CourseDto> getCourseDto(){
        List<Course> courses = courseRepository.findAll();
        List<CourseDto> courseDtos = new ArrayList<>();
        for(Course course : courses){
            CourseDto courseDto = new CourseDto();
            courseDto.setCourseId(course.getCourseId());
            courseDto.setCourseName(course.getCourseName());
            courseDto.setTeacherName(course.getTeacherInfo().getTeacherName());
            courseDto.setCnic(course.getTeacherInfo().getCnic());
            courseDto.setAmount(course.getAmount());
            courseDtos.add(courseDto);
        }
        return courseDtos;

    }

    @GetMapping("/teacher/getList")
    public List<TeacherDto> getTeacherDto(){
        List<Teacher>  teachers = teacherRepository.findAll();
        List<TeacherDto> teacherDtos = new ArrayList<>();
        for (Teacher teacher : teachers){
            TeacherDto teacherDto = new TeacherDto();
            teacherDto.setTeacherId(teacher.getTeacherId());
            teacherDto.setTeacherName(teacher.getTeacherName());
            teacherDto.setPhoneNumber(teacher.getPhoneNumber());
            teacherDto.setExperience(teacher.getExperience());
            teacherDto.setQualification(teacher.getQualification());
            teacherDto.setSalaryAmount(teacher.getSalaryAmount());
            teacherDto.setJoinedDate(teacher.getJoinedDate());
            teacherDto.setCnic(teacher.getCnic());
            teacherDtos.add(teacherDto);
        }
        return teacherDtos;
    }


    @GetMapping("/student/getList")
    public List<StudentDto> getStudentDto(){
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for(Student student : students){
            StudentDto studentDto = new StudentDto();
            studentDto.setStudentId(student.getStudentId());
            studentDto.setStudentName(student.getStudentName());
            studentDto.setEmail(student.getEmail());
            studentDto.setPhoneNumber(student.getPhoneNumber());
            studentDto.setAddress(student.getAddress());
            studentDtos.add(studentDto);
        }
        return studentDtos;

    }




}

