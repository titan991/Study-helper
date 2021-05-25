package com.studyhelper.entity.converter;


import com.studyhelper.entity.form.DisciplineForm;
import com.studyhelper.entity.models.Discipline;
import com.studyhelper.entity.vo.DisciplineVo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DisciplineConverter {
    public Converter<Discipline, DisciplineVo> disciplineVoConverter(){
        return source -> DisciplineVo
                .builder()
                .id(source.getId())
                .nameSubject(source.getNameSubject())
                .semester(source.getSemester())
                .build();

    }
    public Converter<DisciplineForm, Discipline> disciplineFormConverter() {
        return form -> {
            Discipline discipline = new Discipline();
            discipline.setNameSubject(form.getNameSubject());
            discipline.setSemester(form.getSemester());
            return discipline;
        };
    }
}
