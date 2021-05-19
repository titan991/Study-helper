package com.studyhelper.jpa;

import com.studyhelper.entity.models.Groupperson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Groupperson,Long> {
    Optional<Groupperson> findByName(String name);
}
