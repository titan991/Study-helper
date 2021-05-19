package com.studyhelper.controller;

import com.studyhelper.entity.converter.DepartmentConverter;
import com.studyhelper.entity.form.DepartmentForm;
import com.studyhelper.entity.models.Department;
import com.studyhelper.entity.vo.DepartmentVo;
import com.studyhelper.exceptions.ResponseException;
import com.studyhelper.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequestMapping("/department")
@RestController
public class DepartmentController {

  private final DepartmentService departmentService;
  private final DepartmentConverter converter;

  @PostMapping("")
  public Long create(@RequestBody DepartmentForm departmentForm) {
    return departmentService.create(departmentForm);
  }

  @PutMapping("")
  public Long update(@RequestBody DepartmentForm departmentForm) {
    return departmentService.update(departmentForm);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    departmentService.deleteById(id);
  }

  @GetMapping("/{id}")
  public DepartmentVo getById(@PathVariable Long id) {
    var department = departmentService.findByIdNN(id);

    return converter.departmentVoConverter().convert(department);
  }

  @GetMapping("")
  public List<DepartmentVo> getAll() {
    var departments = departmentService.findAll();

    return departments.stream()
        .map(converter.departmentVoConverter()::convert)
        .collect(Collectors.toList());
  }
}
