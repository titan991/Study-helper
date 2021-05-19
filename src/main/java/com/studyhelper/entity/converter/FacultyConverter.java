package com.studyhelper.entity.converter;

import com.studyhelper.entity.form.FacultyForm;
import com.studyhelper.entity.models.Faculty;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FacultyConverter {
    public Converter<FacultyForm, Faculty> facultyConverter(){
        return form -> {
            Faculty faculty=new Faculty();
            faculty.setName(form.getName());
        return faculty;
        };
    }
}
