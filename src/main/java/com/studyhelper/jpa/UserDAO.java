package com.studyhelper.jpa;

import com.studyhelper.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAO extends JpaRepository <User, Long> {
    Optional<User> findByEmail(String email);
}