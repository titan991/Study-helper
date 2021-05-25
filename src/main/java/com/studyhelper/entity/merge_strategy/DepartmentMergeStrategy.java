package com.studyhelper.entity.merge_strategy;

import com.studyhelper.entity.form.DepartmentForm;
import com.studyhelper.entity.form.DisciplineForm;
import com.studyhelper.entity.models.Department;
import com.studyhelper.entity.models.Discipline;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMergeStrategy {
    public Department update(Department discipline, DepartmentForm disciplineForm) {
        discipline.setName(disciplineForm.getName());
        return discipline;
    }
}
