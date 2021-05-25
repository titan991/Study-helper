package com.studyhelper.jpa;

import com.studyhelper.entity.models.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline,Long> {
}
