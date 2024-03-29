package com.studyhelper.service;

import com.studyhelper.entity.converter.LessonConverter;
import com.studyhelper.entity.form.LessonForm;
import com.studyhelper.entity.models.Lesson;
import com.studyhelper.exceptions.ResponseException;
import com.studyhelper.jpa.LessonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LessonServiceImpl implements LessonService{

  private final LessonRepository lessonRepository;
  private final LessonConverter lessonConverter;


  @Override
  public List<Lesson> findAll() {
    return lessonRepository.findAll();
  }

  @Override
  public Lesson findByIdNN(Long id) {
    return lessonRepository.findById(id)
        .orElseThrow(() -> new ResponseException(HttpStatus.NOT_FOUND, "Lesson not found by id = " + id));
  }

  @Override
  public Long create(LessonForm form) {
    var lesson=lessonConverter.LessonFormConverter().convert(form);

    if(lesson==null){
      throw new ResponseException(HttpStatus.I_AM_A_TEAPOT, "Lesson not found");
    }
    return lessonRepository.save(lesson).getId();
  }

  @Override
  public Long update(LessonForm form) {
    return LessonService.super.update(form);
  }

  @Override
  public void deleteById(Long id) { lessonRepository.deleteById(id);
  }
}
