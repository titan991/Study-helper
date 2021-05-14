package com.studyhelper.jpa;

import com.studyhelper.entity.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository <Person, Long> {
    Optional<Person> findByUsername(String username);
}