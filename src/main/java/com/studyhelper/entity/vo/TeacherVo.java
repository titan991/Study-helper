package com.studyhelper.entity.vo;

import com.studyhelper.entity.models.Department;
import com.studyhelper.entity.models.Person;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TeacherVo {
    private Long id;
    private String post;
    private Person person;
}
