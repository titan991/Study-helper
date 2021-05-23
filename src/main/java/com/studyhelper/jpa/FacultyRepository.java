package com.studyhelper.jpa;

import com.studyhelper.entity.models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FacultyRepository extends JpaRepository<Faculty,Long> {
}
