package com.studyhelper.entity.converter;


import com.studyhelper.entity.form.PersonForm;
import com.studyhelper.entity.models.Person;
import com.studyhelper.entity.vo.PersonVo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {

  public Converter<Person, PersonVo> personVoConverter() {
    return source -> PersonVo
            .builder()
            .id(source.getId())
            .username(source.getUsername())
            .password(source.getPassword())
            .fullName(source.getFullName())
            .role(source.getRole())
            .build();
  }
  public Converter<PersonForm, Person> personFormConverter() {
    return form -> {
      Person person = new Person();
      person.setUsername(form.getUsername());
      person.setFullName(form.getFullname());
      person.setRole(form.getRole());
      return person;
    };
  }
}
