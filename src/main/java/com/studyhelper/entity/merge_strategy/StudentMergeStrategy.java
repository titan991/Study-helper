package com.studyhelper.entity.merge_strategy;

import com.studyhelper.entity.form.StudentForm;
import com.studyhelper.entity.models.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMergeStrategy {
    public Student update(Student student, StudentForm studentForm) {
        student.setRecordBookNumber(studentForm.getRecordBookNumber());
        return student;
    }
}
