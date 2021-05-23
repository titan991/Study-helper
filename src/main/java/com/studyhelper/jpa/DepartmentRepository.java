package com.studyhelper.jpa;

import com.studyhelper.entity.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
