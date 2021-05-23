package com.studyhelper.entity.converter;

import com.studyhelper.entity.models.StudentLesson;
import com.studyhelper.entity.vo.StudentLessonVo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentLessonConverter {
    public Converter<StudentLesson, StudentLessonVo> studentLessonVoConverter() {
        return source -> StudentLessonVo
                .builder()
                .id(source.getId())
                .grade(source.getGrade())
                .build();
    }
}
