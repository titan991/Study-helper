package com.studyhelper.controller;

import com.studyhelper.entity.converter.DisciplineConverter;
import com.studyhelper.entity.form.DisciplineForm;
import com.studyhelper.entity.vo.DisciplineVo;
import com.studyhelper.service.DisciplineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequestMapping("/auth/subject")
@RestController
public class DisciplineController {

    private final DisciplineService disciplineService;
    private final DisciplineConverter disciplineConverter;

    @PostMapping("")
    public Long create(@RequestBody DisciplineForm disciplineForm) {
        return disciplineService.create(disciplineForm);
    }

    @PutMapping("")
    public Long update(@RequestBody DisciplineForm disciplineForm) {
        return disciplineService.update(disciplineForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        disciplineService.deleteById(id);
    }

    @GetMapping("/{id}")
    public DisciplineVo getById(@PathVariable Long id) {
        var subject = disciplineService.findByIdNN(id);

        return disciplineConverter.disciplineVoConverter().convert(subject);

    }

    @GetMapping("")
    public List<DisciplineVo> getAll() {
        var subjects = disciplineService.findAll();

        return subjects.stream()
                .map(disciplineConverter.disciplineVoConverter()::convert)
                .collect(Collectors.toList());
    }
}
