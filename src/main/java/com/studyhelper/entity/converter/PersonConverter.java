package com.studyhelper.entity.converter;

import com.studyhelper.entity.form.PersonForm;
import com.studyhelper.entity.models.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {
  public Converter<PersonForm, Person> personConverter() {
    return form -> {
      Person person = new Person();
      person.setUsername(form.getUsername());
      person.setFullname(form.getFullname());
//      person.setId_group(form.getId_group());
 //     person.setId_chair(form.getId_chair());
      return person;
    };
  }
}
