package com.studyhelper.service;

import com.studyhelper.entity.form.FacultyForm;
import com.studyhelper.entity.models.Faculty;

import javax.naming.NameNotFoundException;

public interface FacultyService {
    Faculty findByName(String name) throws NameNotFoundException;
    Long create(FacultyForm facultyForm);
}
