package com.studyhelper.service;

import com.studyhelper.entity.form.GroupForm;
import com.studyhelper.entity.models.Groupperson;

import javax.naming.NameNotFoundException;

public interface GroupService {
    Groupperson findByName(String name) throws NameNotFoundException;
    Long create(GroupForm groupForm);
}
