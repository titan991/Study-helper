package com.studyhelper.entity.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Faculty {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
}
