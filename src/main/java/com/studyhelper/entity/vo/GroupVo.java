package com.studyhelper.entity.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class GroupVo {
    private Long id;
    private String name;
    private Integer course;
    private LocalDate startStudies;
    private LocalDate endStudies;
}
