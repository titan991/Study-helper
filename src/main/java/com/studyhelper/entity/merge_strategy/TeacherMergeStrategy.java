package com.studyhelper.entity.merge_strategy;


import com.studyhelper.entity.form.TeacherForm;
import com.studyhelper.entity.models.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMergeStrategy {
    public Teacher update(Teacher teacher, TeacherForm teacherForm) {
        teacher.setPost(teacherForm.getPost());
        return teacher;
    }
}
