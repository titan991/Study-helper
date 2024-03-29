package com.studyhelper.entity.converter;

import com.studyhelper.entity.form.FacultyForm;
import com.studyhelper.entity.models.Faculty;
import com.studyhelper.entity.vo.FacultyVo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FacultyConverter {
  public Converter<FacultyForm, Faculty> facultyFormConverter() {
    return form -> {
      Faculty faculty = new Faculty();
      faculty.setName(form.getName());
      return faculty;
    };
  }

  public Converter<Faculty, FacultyVo> facultyVoConverter() {
    return source -> FacultyVo
        .builder()
        .id(source.getId())
        .name(source.getName())
        .build();
  }
}
