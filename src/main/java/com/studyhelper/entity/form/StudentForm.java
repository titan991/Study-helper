package com.studyhelper.entity.form;

import com.studyhelper.entity.models.EducationalGroup;
import com.studyhelper.entity.models.Person;
import lombok.Data;

@Data
public class StudentForm {
    private Long id;
    private Person person;
    private String recordBookNumber;
    private EducationalGroup group;
}
