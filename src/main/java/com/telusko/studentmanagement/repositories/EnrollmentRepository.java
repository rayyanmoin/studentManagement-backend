package com.telusko.studentmanagement.repositories;

import com.telusko.studentmanagement.studentManagementObjects.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {




}
