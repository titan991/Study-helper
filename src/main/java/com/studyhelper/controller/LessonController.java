package com.studyhelper.controller;

import com.studyhelper.entity.converter.DepartmentConverter;
import com.studyhelper.entity.converter.LessonConverter;
import com.studyhelper.entity.form.DepartmentForm;
import com.studyhelper.entity.form.LessonForm;
import com.studyhelper.entity.vo.DepartmentVo;
import com.studyhelper.entity.vo.LessonVo;
import com.studyhelper.service.DepartmentService;
import com.studyhelper.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequestMapping("/lesson")
@RestController
public class LessonController {

    private final LessonService lessonService;
    private final LessonConverter lessonConverter;

    @PostMapping("")
    public Long create(@RequestBody LessonForm lessonForm) {
        return lessonService.create(lessonForm);
    }

    @PutMapping("")
    public Long update(@RequestBody LessonForm lessonForm) {
        return lessonService.update(lessonForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lessonService.deleteById(id);
    }

    @GetMapping("/{id}")
    public LessonVo getById(@PathVariable Long id) {
        var lesson = lessonService.findByIdNN(id);

        return lessonConverter.lessonVoConverter().convert(lesson);
    }

    @GetMapping("")
    public List<LessonVo> getAll() {
        var lessons = lessonService.findAll();

        return lessons.stream()
                .map(lessonConverter.lessonVoConverter()::convert)
                .collect(Collectors.toList());
    }
}
