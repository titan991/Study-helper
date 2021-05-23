package com.studyhelper.entity.form;

import com.studyhelper.entity.models.Lesson;
import com.studyhelper.entity.models.Student;
import lombok.Data;

@Data
public class StudentLessonForm {
    private Long id;
    private String grade;
    private Lesson lesson;
    private Student student;
}
