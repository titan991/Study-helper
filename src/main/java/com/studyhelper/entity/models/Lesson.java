package com.studyhelper.entity.models;

import com.studyhelper.entity.models.common.BaseIdEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Lesson extends BaseIdEntity {

    @Column
    private LocalDate date;

    @ManyToOne
    private Discipline discipline;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfLesson typeOfLesson;

    @OneToMany(mappedBy = "lesson")
    private List<StudentLesson> studentLessons;
}
