package com.studyhelper.entity.merge_strategy;


import com.studyhelper.entity.form.DisciplineForm;
import com.studyhelper.entity.models.Discipline;

public class DisciplineMergeStrategy {
    public Discipline update(Discipline discipline, DisciplineForm disciplineForm) {
        discipline.setNameSubject(disciplineForm.getNameSubject());
        return discipline;
    }
}
