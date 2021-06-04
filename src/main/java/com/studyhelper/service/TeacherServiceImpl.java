package com.studyhelper.service;


import com.studyhelper.entity.converter.TeacherConverter;
import com.studyhelper.entity.form.TeacherForm;
import com.studyhelper.entity.merge_strategy.TeacherMergeStrategy;
import com.studyhelper.entity.models.Teacher;
import com.studyhelper.exceptions.ResponseException;
import com.studyhelper.jpa.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService{
    private final TeacherRepository teacherRepository;
    private final TeacherConverter teacherConverter;
    private final TeacherMergeStrategy mergeStrategy;

    @Override
    public List<Teacher> findAll() { return teacherRepository.findAll();
    }

    @Override
    public Teacher findByIdNN(Long id) {
        return teacherRepository
                .findById(id)
                .orElseThrow(() -> new ResponseException(HttpStatus.BAD_REQUEST, "Teacher not found by id = " + id));
    }

    @Override
    public Long create(TeacherForm teacherForm) {
        var teacher = teacherConverter.teacherFormConverter().convert(teacherForm);

        if (teacher == null) {
            throw new ResponseException(HttpStatus.I_AM_A_TEAPOT, "department not found");
        }

        return teacherRepository.save(teacher).getId();
    }

    @Override
    public Long update(TeacherForm teacherForm) {
        var teacher = findByIdNN(teacherForm.getId());

        teacher = mergeStrategy.update(teacher, teacherForm);

        return teacherRepository.save(teacher).getId();
    }

    @Override
    public void deleteById(Long id) { teacherRepository.deleteById(id);
    }
}
