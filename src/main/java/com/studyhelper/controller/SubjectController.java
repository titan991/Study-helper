package com.studyhelper.controller;

import com.studyhelper.entity.converter.SubjectConverter;
import com.studyhelper.entity.form.DisciplineForm;
import com.studyhelper.entity.vo.DisciplineVo;
import com.studyhelper.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequestMapping("/subject")
@RestController
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectConverter subjectConverter;

    @PostMapping("")
    public Long create(@RequestBody DisciplineForm disciplineForm) {
        return subjectService.create(disciplineForm);
    }

    @PutMapping("")
    public Long update(@RequestBody DisciplineForm disciplineForm) {
        return subjectService.update(disciplineForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subjectService.deleteById(id);
    }

    @GetMapping("/{id}")
    public DisciplineVo getById(@PathVariable Long id) {
        var subject = subjectService.findByIdNN(id);

        return subjectConverter.subjectVoConverter().convert(subject);

    }

    @GetMapping("")
    public List<DisciplineVo> getAll() {
        var subjects = subjectService.findAll();

        return subjects.stream()
                .map(subjectConverter.subjectVoConverter()::convert)
                .collect(Collectors.toList());
    }
}
