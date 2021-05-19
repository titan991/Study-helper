package com.studyhelper.entity.converter;

import com.studyhelper.entity.form.GroupForm;
import com.studyhelper.entity.models.EducationalGroup;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GroupConverter {

    public Converter<GroupForm, EducationalGroup> groupConverter() {
        return form -> {
            EducationalGroup educationalGroup = new EducationalGroup();
            educationalGroup.setName(form.getName());
            educationalGroup.setCourse(form.getCourse());
            educationalGroup.setStartStudies(form.getStartStudies());
            educationalGroup.setEndStudies(form.getEndStudies());
            return educationalGroup;
        };
    }


}
