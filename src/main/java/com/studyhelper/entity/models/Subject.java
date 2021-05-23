package com.studyhelper.entity.models;

import com.studyhelper.entity.models.common.BaseIdEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Subject extends BaseIdEntity {
    @Column(name = "name_subject")
    private String nameSubject;

    @Column
    private Integer semester;

    @OneToMany(mappedBy = "subject")
    private List<EducationalGroup> educationalGroups;

    @OneToMany(mappedBy = "subject")
    private List<Lesson> lessons;
}
