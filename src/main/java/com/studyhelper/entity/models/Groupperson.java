package com.studyhelper.entity.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Groupperson {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private Integer course;

    @Column
    private Date start_studies;

    @Column
    private Date end_studies;

    @ManyToOne
    private Department department;

    @OneToMany
    private List<Person> persons;
}
