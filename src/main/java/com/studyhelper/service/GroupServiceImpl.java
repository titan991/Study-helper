package com.studyhelper.service;

import com.studyhelper.entity.form.GroupForm;
import com.studyhelper.entity.merge_strategy.GroupMergeStrategy;
import com.studyhelper.entity.models.EducationalGroup;
import com.studyhelper.jpa.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GroupServiceImpl implements GroupService{

  private final GroupRepository groupRepository;
  private final GroupMergeStrategy mergeStrategy;

  @Override
  public List<EducationalGroup> findAll() {
    return GroupService.super.findAll();
  }

  @Override
  public EducationalGroup findByIdNN(Long id) {
    return GroupService.super.findByIdNN(id);
  }

  @Override
  public Long create(GroupForm form) {
    EducationalGroup educationalGroup = mergeStrategy.create(form);
    return groupRepository.save(educationalGroup).getId();
  }

  @Override
  public Long update(GroupForm form) {
    return GroupService.super.update(form);
  }

  @Override
  public void deleteById(Long id) {
    GroupService.super.deleteById(id);
  }
}
