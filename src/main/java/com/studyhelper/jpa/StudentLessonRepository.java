package com.studyhelper.jpa;

import com.studyhelper.entity.models.StudentLesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentLessonRepository extends JpaRepository<StudentLesson, Long> {
}
