package com.studyhelper.entity.vo;

import com.studyhelper.entity.models.TypeOfLesson;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class LessonVo {
    private Long id;
    private LocalDate date;
    private TypeOfLesson typeOfLesson;
}
