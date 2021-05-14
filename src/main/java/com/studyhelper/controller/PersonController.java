package com.studyhelper.controller;

import com.studyhelper.entity.form.PersonForm;
import com.studyhelper.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

  private final PersonService personService;

  @PostMapping("")
  public Long create(@RequestBody PersonForm personForm) {
    return personService.create(personForm);
  }
}
