package com.studyhelper.service;

import com.studyhelper.entity.form.DepartmentForm;
import com.studyhelper.entity.models.Department;
import com.studyhelper.service.common.CrudService;

import javax.naming.NameNotFoundException;

public interface DepartmentService extends CrudService<Department, DepartmentForm> {
}
