package com.studyhelper.entity.converter;


import com.studyhelper.entity.models.Subject;
import com.studyhelper.entity.vo.SubjectVo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SubjectConverter {
    public Converter<Subject, SubjectVo> subjectVoConverter(){
        return source -> SubjectVo
                .builder()
                .id(source.getId())
                .nameSubject(source.getNameSubject())
                .semester(source.getSemester())
                .build();

    }
}
