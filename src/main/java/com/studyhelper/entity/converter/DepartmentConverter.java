package com.studyhelper.entity.converter;

import com.studyhelper.entity.form.DepartmentForm;
import com.studyhelper.entity.models.Department;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter {
    public Converter<DepartmentForm, Department> chairConverter(){
        return form -> {
           Department department =new Department();
           department.setName(form.getName());
           return department;
        };
    }
}
