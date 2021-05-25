package com.studyhelper.service;

import com.studyhelper.entity.converter.StudentLessonConverter;
import com.studyhelper.entity.form.StudentLessonForm;
import com.studyhelper.entity.models.StudentLesson;
import com.studyhelper.exceptions.ResponseException;
import com.studyhelper.jpa.StudentLessonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentLessonServiceImpl implements StudentLessonService{

    private final StudentLessonRepository studentLessonRepository;
    private final StudentLessonConverter studentLessonConverter;

    @Override
    public List<StudentLesson> findAll() {
        return studentLessonRepository.findAll();
    }

    @Override
    public StudentLesson findByIdNN(Long id) {
        return studentLessonRepository
                .findById(id)
                .orElseThrow(() -> new ResponseException(HttpStatus.BAD_REQUEST, "StudentLesson not found by id = " + id));
    }

    @Override
    public Long create(StudentLessonForm form) {
        var studlesson =studentLessonConverter.studentLessonFormConverter().convert(form);

        if(studlesson==null){
            throw new ResponseException(HttpStatus.I_AM_A_TEAPOT, "Person not found");
        }
        return studentLessonRepository.save(studlesson).getId();
    }

    @Override
    public Long update(StudentLessonForm form) {
        return StudentLessonService.super.update(form);
    }

    @Override
    public void deleteById(Long id) { studentLessonRepository.deleteById(id);
    }
}
