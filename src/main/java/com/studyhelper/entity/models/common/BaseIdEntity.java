package com.studyhelper.entity.models.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EqualsAndHashCode
@Setter
@Getter
public class BaseIdEntity{

  @Id
  @GeneratedValue
  private Long id;

}
