package com.studyhelper.entity.form;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class GroupForm {
    private Long id;
    private String name;
    private Integer course;
    private LocalDate startStudies;
    private LocalDate endStudies;
    private Long departmentId;
}
