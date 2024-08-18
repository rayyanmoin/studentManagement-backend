package com.telusko.studentmanagement.repositories;

import com.telusko.studentmanagement.studentManagementObjects.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
