package com.studyhelper.entity.models;

import com.studyhelper.entity.models.common.BaseIdEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Student extends BaseIdEntity {

  @ManyToOne
  private Person person;

  @Column(name = "record_book_number")
  private String recordBookNumber;

  @ManyToOne
  private EducationalGroup group;

}
