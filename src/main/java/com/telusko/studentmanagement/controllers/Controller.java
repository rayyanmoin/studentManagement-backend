package com.telusko.studentmanagement.controllers;
import com.telusko.studentmanagement.dto.*;
import com.telusko.studentmanagement.repositories.CourseRepository;
import com.telusko.studentmanagement.repositories.EnrollmentRepository;
import com.telusko.studentmanagement.repositories.StudentRepository;
import com.telusko.studentmanagement.repositories.TeacherRepository;
import com.telusko.studentmanagement.studentManagementObjects.Course;
import com.telusko.studentmanagement.studentManagementObjects.Enrollment;
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


    @PostMapping("/teacher/add")
    public String addTeacher(@RequestBody TeacherAddDto teacherAddDto){
        Teacher teacher = new Teacher();
        teacher.setPhoneNumber(teacherAddDto.getPhoneNumber());
        teacher.setExperience(teacherAddDto.getExperience());
        teacher.setTeacherName(teacherAddDto.getTeacherName());
        teacher.setQualification(teacherAddDto.getQualification());
        teacher.setCnic(teacherAddDto.getCnic());
        teacher.setJoinedDate(teacherAddDto.getJoinedDate());
        teacher.setSalaryAmount(teacherAddDto.getSalaryAmount());
        teacherRepository.save(teacher);
        return "Teacher Added Successfully";
    }

    @PostMapping("/course/add")
    public String addCourse(@RequestBody CourseAddDto courseAddDto){
        Course course = new Course();
        course.setCourseName(courseAddDto.getCourseName());
        course.setAmount(courseAddDto.getAmount());
        course.setTeacherId(courseAddDto.getTeacherId());

        Course savedcourse = courseRepository.save(course);
        return "Course Added Successfully";
    }

    @PostMapping("/student/add")
    public String addStudent(@RequestBody StudentAddDto studentAddDto){
        Student student = new Student();

        student.setStudentName(studentAddDto.getStudentName());
        student.setEmail(studentAddDto.getEmail());
        student.setPhoneNumber(studentAddDto.getPhoneNumber());
        student.setAddress(studentAddDto.getAddress());

        Student savedStudent = studentRepository.save(student);
        for(EnrollmentDto enrollmentDto: studentAddDto.getCourses()) {
            Enrollment enrollment = new Enrollment();
            enrollment.setStudentId(savedStudent.getStudentId());
            enrollment.setCourseId(enrollmentDto.getCourseId());
            enrollment.setEnrollmentDate(enrollmentDto.getEnrollmentDate());

            enrollmentRepository.save(enrollment);

        }
        return "Student and courses against student Added Successfully";
    }

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

    @GetMapping("/teacher/getDropList")
    public List<TeacherDropDto> getTeacherDropDto(){
        List<Teacher>  teachers = teacherRepository.findAll();
        List<TeacherDropDto> teacherDropDtos = new ArrayList<>();
        for (Teacher teacher : teachers){
            TeacherDropDto teacherDto = new TeacherDropDto();
            teacherDto.setTeacherId(teacher.getTeacherId());
            teacherDto.setTeacherName(teacher.getTeacherName());

            teacherDropDtos.add(teacherDto);
        }
        return teacherDropDtos;
    }

    @GetMapping("/course/getOnlyCourseList")
    public List<OnlyCourseDto> getOnlyCourseDto() {
        List<Course> courses = courseRepository.findAll();
        List<OnlyCourseDto> onlyCourseDtoList = new ArrayList<>();
        for (Course course : courses) {
            OnlyCourseDto onlyCourseDto = new OnlyCourseDto();
            onlyCourseDto.setCourseId(course.getCourseId());
            onlyCourseDto.setCourseName(course.getCourseName());
            onlyCourseDtoList.add(onlyCourseDto);
        }
        return onlyCourseDtoList;

    }

    @GetMapping("/student/getList")
    public List<StudentDto> getStudentDto(){
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for(Student student : students) {
            StudentDto studentDto = new StudentDto();
            studentDto.setStudentId(student.getStudentId());
            studentDto.setStudentName(student.getStudentName());
            studentDto.setEmail(student.getEmail());
            studentDto.setPhoneNumber(student.getPhoneNumber());
            studentDto.setAddress(student.getAddress());

            List<StudentCoursesDto> courses = new ArrayList<>();
            List<Enrollment> enrollmentList = enrollmentRepository.findByStudentId(student.getStudentId());

            for (Enrollment enrollment :enrollmentList) {
                StudentCoursesDto courseDto = new StudentCoursesDto();
                courseDto.setCourseId(enrollment.getCourseId());
                courseDto.setCourseName(enrollment.getCourseInfo().getCourseName());
                courses.add(courseDto);
            }
            studentDto.setCourses(courses);
            studentDtos.add(studentDto);
        }
        return studentDtos;

    }




}

