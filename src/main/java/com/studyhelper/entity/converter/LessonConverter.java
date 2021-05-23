package com.studyhelper.entity.converter;

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
}
