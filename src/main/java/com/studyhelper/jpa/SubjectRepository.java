package com.studyhelper.jpa;

import com.studyhelper.entity.models.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Discipline,Long> {
}
