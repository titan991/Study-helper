package com.studyhelper.jpa;

import com.studyhelper.entity.models.EducationalGroup;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupRepository extends JpaRepository<EducationalGroup,Long> {
}
