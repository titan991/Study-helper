package com.studyhelper.entity.converter;

import com.studyhelper.entity.form.GroupForm;
import com.studyhelper.entity.models.EducationalGroup;
import com.studyhelper.entity.vo.GroupVo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GroupConverter {

    public Converter<EducationalGroup, GroupVo> groupVoConverter() {
        return source -> GroupVo
                .builder()
                .id(source.getId())
                .name(source.getName())
                .course(source.getCourse())
                .endStudies(source.getEndStudies())
                .startStudies(source.getStartStudies())
                .build();
    }
    public Converter<GroupForm, EducationalGroup> educationalGroupFormConverter() {
        return form -> {
            EducationalGroup educationalGroup = new EducationalGroup();
            educationalGroup.setName(form.getName());
            educationalGroup.setCourse(form.getCourse());
            educationalGroup.setEndStudies(form.getEndStudies());
            educationalGroup.setStartStudies(form.getStartStudies());
            return educationalGroup;
        };
    }
}
