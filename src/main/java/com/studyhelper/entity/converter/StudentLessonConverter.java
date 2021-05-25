package com.studyhelper.entity.converter;

import com.studyhelper.entity.form.GroupForm;
import com.studyhelper.entity.form.StudentLessonForm;
import com.studyhelper.entity.models.EducationalGroup;
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
    public Converter<StudentLessonForm, StudentLesson> studentLessonFormConverter() {
        return form -> {
            StudentLesson studentLesson = new StudentLesson();
            studentLesson.setGrade(form.getGrade());
            studentLesson.setStudent(form.getStudent());
            studentLesson.setLesson(form.getLesson());
            return studentLesson;
        };
    }
}
