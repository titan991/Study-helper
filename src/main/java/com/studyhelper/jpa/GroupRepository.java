package com.studyhelper.jpa;

import com.studyhelper.entity.models.EducationalGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<EducationalGroup,Long> {
    Optional<EducationalGroup> findByName(String name);
}
