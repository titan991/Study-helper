package com.studyhelper.jpa;

import com.studyhelper.entity.models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
}
