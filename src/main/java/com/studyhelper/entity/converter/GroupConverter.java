package com.studyhelper.entity.converter;

import com.studyhelper.entity.form.GroupForm;
import com.studyhelper.entity.models.Groupperson;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GroupConverter {

    public Converter<GroupForm, Groupperson> groupConverter() {
        return form -> {
            Groupperson groupperson = new Groupperson();
            groupperson.setName(form.getName());
            groupperson.setCourse(form.getCourse());
            groupperson.setStart_studies(form.getStart_studies());
            groupperson.setEnd_studies(form.getEnd_studies());
            return groupperson;
        };
    }


}
