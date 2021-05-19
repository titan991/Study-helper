package com.studyhelper.controller;

import com.studyhelper.entity.converter.FacultyConverter;
import com.studyhelper.entity.form.FacultyForm;
import com.studyhelper.entity.models.Faculty;
import com.studyhelper.entity.vo.FacultyVo;
import com.studyhelper.exceptions.ResponseException;
import com.studyhelper.service.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("/faculty")
@RestController
@AllArgsConstructor
public class FacultyController {

  private final FacultyService facultyService;

  private final FacultyConverter converter;

  @PostMapping("")
  public Long create (@RequestBody FacultyForm form) {
    return facultyService.create(form);
  }

  @PutMapping("")
  public Long update (@RequestBody FacultyForm form) {
    return facultyService.update(form);
  }

  @GetMapping("/{id}")
  public FacultyVo getById(@PathVariable Long id) {

    var faculty = facultyService.findByIdNN(id);

    return converter.facultyVoConverter().convert(faculty);
  }

  @GetMapping("")
  public List<FacultyVo> getAll() {
    var faculties = facultyService.findAll();

    return faculties.stream()
        .map(converter.facultyVoConverter()::convert)
        .collect(Collectors.toList());
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    facultyService.deleteById(id);
  }
}
