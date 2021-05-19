package com.studyhelper.entity.models;

import com.studyhelper.entity.models.common.BaseIdEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Teacher extends BaseIdEntity {

  private String post;

  @ManyToOne
  private Department department;

  @ManyToOne
  private Person person;

}
