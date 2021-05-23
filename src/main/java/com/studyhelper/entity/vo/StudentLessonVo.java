package com.studyhelper.entity.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentLessonVo {
    private Long id;
    private String grade;
}
