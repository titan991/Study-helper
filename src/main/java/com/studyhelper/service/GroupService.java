package com.studyhelper.service;

import com.studyhelper.entity.form.GroupForm;
import com.studyhelper.entity.models.EducationalGroup;

import javax.naming.NameNotFoundException;

public interface GroupService {
    EducationalGroup findByName(String name) throws NameNotFoundException;
    Long create(GroupForm groupForm);
}
