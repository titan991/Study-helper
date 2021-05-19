package com.studyhelper.entity.models;


import com.studyhelper.entity.models.common.BaseIdEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "educational_group")
public class EducationalGroup extends BaseIdEntity {
    @Column
    private String name;

    @Column
    private Integer course;

    @Column(name = "start_studies")
    private LocalDate startStudies;

    @Column(name = "end_studies")
    private LocalDate endStudies;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "group")
    private List<Student> students;
}
