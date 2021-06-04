package com.studyhelper.entity.form;

import com.studyhelper.entity.models.Department;
import com.studyhelper.entity.models.Person;
import lombok.Data;

@Data
public class TeacherForm {
    private Long id;
    private String post;
    private Department department;
    private Person person;
}
