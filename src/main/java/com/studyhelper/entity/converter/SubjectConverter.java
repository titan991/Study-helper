package com.studyhelper.entity.converter;


import com.studyhelper.entity.models.Discipline;
import com.studyhelper.entity.vo.DisciplineVo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SubjectConverter {
    public Converter<Discipline, DisciplineVo> subjectVoConverter(){
        return source -> DisciplineVo
                .builder()
                .id(source.getId())
                .nameSubject(source.getNameSubject())
                .semester(source.getSemester())
                .build();

    }
}
