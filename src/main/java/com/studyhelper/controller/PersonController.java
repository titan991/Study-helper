package com.studyhelper.controller;

import com.studyhelper.entity.converter.PersonConverter;
import com.studyhelper.entity.form.DepartmentForm;
import com.studyhelper.entity.form.PersonForm;
import com.studyhelper.entity.vo.DepartmentVo;
import com.studyhelper.entity.vo.PersonVo;
import com.studyhelper.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

  private final PersonService personService;
  private final PersonConverter personConverter;

  @PostMapping("")
  public Long create(@RequestBody PersonForm personForm) {
    return personService.create(personForm);
  }

  @PutMapping("")
  public Long update(@RequestBody PersonForm personForm) {
    return personService.update(personForm);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    personService.deleteById(id);
  }

  @GetMapping("/{id}")
  public PersonVo getById(@PathVariable Long id) {
    var person = personService.findByIdNN(id);

    return personConverter.personVoConverter().convert(person);
  }

  @GetMapping("")
  public List<PersonVo> getAll() {
    var persons = personService.findAll();

    return persons.stream()
            .map(personConverter.personVoConverter()::convert)
            .collect(Collectors.toList());
  }
}
