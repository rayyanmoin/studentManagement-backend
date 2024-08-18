package com.telusko.studentmanagement.repositories;

import com.telusko.studentmanagement.studentManagementObjects.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {


}
