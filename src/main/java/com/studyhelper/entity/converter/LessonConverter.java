package com.studyhelper.entity.converter;

import com.studyhelper.entity.form.GroupForm;
import com.studyhelper.entity.form.LessonForm;
import com.studyhelper.entity.models.EducationalGroup;
import com.studyhelper.entity.models.Lesson;
import com.studyhelper.entity.vo.LessonVo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LessonConverter {
    public Converter<Lesson, LessonVo> lessonVoConverter(){
        return source -> LessonVo
                .builder()
                .id(source.getId())
                .date(source.getDate())
                .typeOfLesson(source.getTypeOfLesson())
                .build();
    }
    public Converter<LessonForm, Lesson> LessonFormConverter() {
        return form -> {
            Lesson lesson = new Lesson();
            lesson.setDate(form.getDate());
            lesson.setTypeOfLesson(form.getTypeOfLesson());
            lesson.setDiscipline(form.getDiscipline());
            return lesson;
        };
    }
}
