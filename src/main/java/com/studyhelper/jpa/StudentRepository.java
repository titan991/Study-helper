package com.studyhelper.jpa;

import com.studyhelper.entity.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
