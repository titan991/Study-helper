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
public class Department extends BaseIdEntity {
    @Column
    private String name;

    @Column
    private String abbreviation;

    @ManyToOne
    private Faculty faculty;

}
