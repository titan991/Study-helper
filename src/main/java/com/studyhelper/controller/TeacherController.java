package com.studyhelper.controller;

import com.studyhelper.entity.converter.TeacherConverter;
import com.studyhelper.entity.form.TeacherForm;
import com.studyhelper.entity.vo.TeacherVo;
import com.studyhelper.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequestMapping("/auth/teacher")
@RestController
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherConverter converter;

    @PostMapping("")
    public Long create(@RequestBody TeacherForm teacherForm) {
        return teacherService.create(teacherForm);
    }

    @PutMapping("")
    public Long update(@RequestBody TeacherForm teacherForm) {
        return teacherService.update(teacherForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teacherService.deleteById(id);
    }

    @GetMapping("/{id}")
    public TeacherVo getById(@PathVariable Long id) {
        var teacher = teacherService.findByIdNN(id);

        return converter.teacherVoConverter().convert(teacher);
    }

    @GetMapping("")
    public List<TeacherVo> getAll() {
        var teachers = teacherService.findAll();

        return teachers.stream()
                .map(converter.teacherVoConverter()::convert)
                .collect(Collectors.toList());
    }
}
