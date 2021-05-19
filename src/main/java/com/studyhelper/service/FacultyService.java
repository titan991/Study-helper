package com.studyhelper.service;

import com.studyhelper.entity.form.FacultyForm;
import com.studyhelper.entity.models.Faculty;

import java.util.List;

public interface FacultyService {
    List<Faculty> findAll();

    Faculty findByIdNN(Long id);

    Long create(FacultyForm facultyForm);

    Long update(FacultyForm facultyForm);

    void deleteById(Long id);

}
