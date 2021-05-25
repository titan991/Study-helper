package com.studyhelper.entity.converter;

import com.studyhelper.entity.form.DepartmentForm;
import com.studyhelper.entity.form.FacultyForm;
import com.studyhelper.entity.models.Department;
import com.studyhelper.entity.models.Faculty;
import com.studyhelper.entity.vo.DepartmentVo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter {
    public Converter<Department, DepartmentVo> departmentVoConverter(){
        return source -> DepartmentVo
            .builder()
            .id(source.getId())
            .name(source.getName())
            .abbreviation(source.getName())
            .build();
    }
    public Converter<DepartmentForm, Department> departmentFormConverter() {
        return form -> {
            Department department = new Department();
            department.setName(form.getName());
            department.setAbbreviation(form.getAbbreviation());
            return department;
        };
    }
}
