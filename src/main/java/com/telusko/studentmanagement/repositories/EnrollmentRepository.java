package com.telusko.studentmanagement.repositories;

import com.telusko.studentmanagement.studentManagementObjects.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {

 List<Enrollment> findByStudentId(Long studentId);

}
