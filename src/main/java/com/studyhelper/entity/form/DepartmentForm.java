package com.studyhelper.entity.form;

import lombok.Data;

@Data
public class DepartmentForm {
    private Long id;
    private String name;
    private String abbreviation;
    private Long facultyId;
}
