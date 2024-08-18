package com.telusko.studentmanagement.repositories;

import com.telusko.studentmanagement.studentManagementObjects.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {


}
