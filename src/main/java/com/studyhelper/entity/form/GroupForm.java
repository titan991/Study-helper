package com.studyhelper.entity.form;

import lombok.Data;

import java.util.Date;

@Data
public class GroupForm {
    private String name;
    private Integer course;
    private Date start_studies;
    private Date end_studies;
}
