package com.studyhelper.entity.form;

import lombok.Data;

@Data
public class DisciplineForm {
    private Long id;
    private String nameSubject;
    private Integer semester;
    private Long educationalGroupId;
}
