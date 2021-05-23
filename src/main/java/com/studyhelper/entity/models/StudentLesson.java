package com.studyhelper.entity.models;

import com.studyhelper.entity.models.common.BaseIdEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class StudentLesson extends BaseIdEntity {

    @Column
    private String grade;

    @ManyToOne
    private Lesson lesson;

    @ManyToOne
    private Student student;

}
