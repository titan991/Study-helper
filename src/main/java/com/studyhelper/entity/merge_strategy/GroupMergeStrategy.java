package com.studyhelper.entity.merge_strategy;

import com.studyhelper.entity.form.GroupForm;
import com.studyhelper.entity.models.EducationalGroup;
import com.studyhelper.jpa.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GroupMergeStrategy {

  private final DepartmentRepository departmentRepository;

  public EducationalGroup create (GroupForm form) {
    var group =  new EducationalGroup();

    group.setName(form.getName());
    group.setEndStudies(form.getEndStudies());
    group.setStartStudies(form.getStartStudies());
    group.setCourse(form.getCourse());
    group.setDepartment(departmentRepository
        .findById(form.getDepartmentId())
        .orElse(null));

    return group;
  }
  public EducationalGroup update(EducationalGroup educationalGroup, GroupForm groupForm) {
    educationalGroup.setName(groupForm.getName());
    return educationalGroup;
  }
}
