package com.studyhelper.service;

import com.studyhelper.entity.models.Department;

import javax.naming.NameNotFoundException;

public interface DepartmentService {
    Department findByName(String name) throws NameNotFoundException;
}
