package com.studyhelper.controller;

import com.studyhelper.entity.converter.DepartmentConverter;
import com.studyhelper.entity.converter.StudentLessonConverter;
import com.studyhelper.entity.form.DepartmentForm;
import com.studyhelper.entity.form.StudentLessonForm;
import com.studyhelper.entity.vo.DepartmentVo;
import com.studyhelper.entity.vo.StudentLessonVo;
import com.studyhelper.service.DepartmentService;
import com.studyhelper.service.StudentLessonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequestMapping("/studentlesson")
@RestController
public class StudentLessonController {
    private final StudentLessonService studentLessonService;
    private final StudentLessonConverter studentLessonConverter;

    @PostMapping("")
    public Long create(@RequestBody StudentLessonForm studentLessonForm) { return studentLessonService.create(studentLessonForm);
    }

    @PutMapping("")
    public Long update(@RequestBody StudentLessonForm studentLessonForm) { return studentLessonService.update(studentLessonForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentLessonService.deleteById(id);
    }

    @GetMapping("/{id}")
    public StudentLessonVo getById(@PathVariable Long id) {
        var studentlesson = studentLessonService.findByIdNN(id);

        return studentLessonConverter.studentLessonVoConverter().convert(studentlesson);
    }

    @GetMapping("")
    public List<StudentLessonVo> getAll() {
        var studentlessons = studentLessonService.findAll();

        return studentlessons.stream()
                .map(studentLessonConverter.studentLessonVoConverter()::convert)
                .collect(Collectors.toList());
    }
}
