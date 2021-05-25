package com.studyhelper.service;

import com.studyhelper.entity.converter.GroupConverter;
import com.studyhelper.entity.form.GroupForm;
import com.studyhelper.entity.merge_strategy.GroupMergeStrategy;
import com.studyhelper.entity.models.EducationalGroup;
import com.studyhelper.exceptions.ResponseException;
import com.studyhelper.jpa.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GroupServiceImpl implements GroupService{

  private final GroupRepository groupRepository;
  private final GroupMergeStrategy mergeStrategy;

  @Override
  public List<EducationalGroup> findAll() {
    return groupRepository.findAll();
  }

  @Override
  public EducationalGroup findByIdNN(Long id) {
    return groupRepository
            .findById(id)
            .orElseThrow(() -> new ResponseException(HttpStatus.BAD_REQUEST, "EducationalGroup not found by id = " + id));
  }

  @Override
  public Long create(GroupForm form) {
    EducationalGroup educationalGroup = mergeStrategy.create(form);
    if (educationalGroup == null) {
      throw new ResponseException(HttpStatus.I_AM_A_TEAPOT, "EducationalGroup not found");
    }
    return groupRepository.save(educationalGroup).getId();
  }

  @Override
  public Long update(GroupForm form) {
    var education= findByIdNN(form.getId());

    education=mergeStrategy.update(education,form);

    return groupRepository.save(education).getId();
  }

  @Override
  public void deleteById(Long id) {
    groupRepository.deleteById(id);
  }
}
