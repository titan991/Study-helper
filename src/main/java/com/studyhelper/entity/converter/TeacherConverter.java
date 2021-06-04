package com.studyhelper.entity.converter;


import com.studyhelper.entity.form.TeacherForm;
import com.studyhelper.entity.models.Teacher;
import com.studyhelper.entity.vo.TeacherVo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



@Component
public class TeacherConverter {
    public Converter<Teacher, TeacherVo> teacherVoConverter(){
        return source -> TeacherVo
                .builder()
                .id(source.getId())
                .post(source.getPost())
                .person(source.getPerson())
                .build();
    }
    public Converter<TeacherForm, Teacher> teacherFormConverter() {
        return form -> {
            Teacher teacher = new Teacher();
            teacher.setPost(form.getPost());
            teacher.setPerson(form.getPerson());
            teacher.setDepartment(form.getDepartment());
            return teacher;
        };
    }
}
