package com.studyhelper.entity.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SubjectVo {
    private Long id;
    private String nameSubject;
    private Integer semester;

}
