package com.studyhelper.entity.converter;

import com.studyhelper.entity.form.StudentForm;
import com.studyhelper.entity.models.Person;
import com.studyhelper.entity.models.Student;
import com.studyhelper.entity.vo.StudentVo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {
    public Converter<Student, StudentVo> studentVoConverter(){

        return source -> StudentVo
                .builder()
                .id(source.getId())
                .recordBookNumber(source.getRecordBookNumber())
                .person(source.getPerson())
                .build();
    }
    public Converter<StudentForm, Student> studentFormConverter() {
        return form -> {
            Student student=new Student();
            student.setRecordBookNumber(form.getRecordBookNumber());
            student.setGroup(form.getGroup());
            student.setPerson(form.getPerson());
            return student;
        };
    }
}
