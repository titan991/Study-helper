package com.studyhelper.entity.form;

import com.studyhelper.entity.models.Discipline;
import com.studyhelper.entity.models.TypeOfLesson;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LessonForm {
    private Long id;
    private LocalDate date;
    private Discipline discipline;
    private TypeOfLesson typeOfLesson;
}
