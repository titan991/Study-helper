package com.studyhelper.entity.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DepartmentVo {
  private Long id;
  private String name;
  private String abbreviation;
}
