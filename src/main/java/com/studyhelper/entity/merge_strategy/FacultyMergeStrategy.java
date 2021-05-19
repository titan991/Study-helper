package com.studyhelper.entity.merge_strategy;

import com.studyhelper.entity.form.FacultyForm;
import com.studyhelper.entity.models.Faculty;
import org.springframework.stereotype.Component;

@Component
public class FacultyMergeStrategy {

  public Faculty update(Faculty faculty, FacultyForm facultyForm) {
    faculty.setName(facultyForm.getName());
    return faculty;
  }

}
