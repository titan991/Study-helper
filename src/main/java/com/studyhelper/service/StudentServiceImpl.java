package com.studyhelper.service;

import com.studyhelper.entity.converter.StudentConverter;
import com.studyhelper.entity.form.StudentForm;
import com.studyhelper.entity.merge_strategy.StudentMergeStrategy;
import com.studyhelper.entity.models.Student;
import com.studyhelper.exceptions.ResponseException;
import com.studyhelper.jpa.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;
    private final StudentMergeStrategy mergeStrategy;

    @Override
    public List<Student> findAll() { return studentRepository.findAll();
    }

    @Override
    public Student findByIdNN(Long id) {
        return studentRepository
                .findById(id)
                .orElseThrow(() -> new ResponseException(HttpStatus.BAD_REQUEST, "Student not found by id = " + id));
    }

    @Override
    public Long create(StudentForm studentForm) {
        var student = studentConverter.studentFormConverter().convert(studentForm);

        if (student == null) {
            throw new ResponseException(HttpStatus.I_AM_A_TEAPOT, "student not found");
        }

        return studentRepository.save(student).getId();
    }

    @Override
    public Long update(StudentForm studentForm) {
        var student = findByIdNN(studentForm.getId());

        student = mergeStrategy.update(student, studentForm);

        return studentRepository.save(student).getId();
    }

    @Override
    public void deleteById(Long id) { studentRepository.deleteById(id);
    }
}
