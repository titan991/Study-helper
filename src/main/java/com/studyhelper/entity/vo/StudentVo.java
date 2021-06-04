package com.studyhelper.entity.vo;

import com.studyhelper.entity.models.Person;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentVo {
    private Long id;
    private String recordBookNumber;
    private Person person;
}
