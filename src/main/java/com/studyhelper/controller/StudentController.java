package com.studyhelper.controller;

import com.studyhelper.entity.converter.StudentConverter;
import com.studyhelper.entity.form.StudentForm;
import com.studyhelper.entity.vo.StudentVo;
import com.studyhelper.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequestMapping("/auth/student")
@RestController
public class StudentController {
    private final StudentService studentService;
    private final StudentConverter converter;

    @PostMapping("")
    public Long create(@RequestBody StudentForm studentForm) {
        return studentService.create(studentForm);
    }

    @PutMapping("")
    public Long update(@RequestBody StudentForm studentForm) {
        return studentService.update(studentForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @GetMapping("/{id}")
    public StudentVo getById(@PathVariable Long id) {
        var student = studentService.findByIdNN(id);

        return converter.studentVoConverter().convert(student);
    }

    @GetMapping("")
    public List<StudentVo> getAll() {
        var students = studentService.findAll();

        return students.stream()
                .map(converter.studentVoConverter()::convert)
                .collect(Collectors.toList());
    }
}
