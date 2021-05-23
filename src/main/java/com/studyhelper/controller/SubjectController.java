package com.studyhelper.controller;

import com.studyhelper.entity.converter.SubjectConverter;
import com.studyhelper.entity.form.SubjectForm;
import com.studyhelper.entity.vo.DepartmentVo;
import com.studyhelper.entity.vo.SubjectVo;
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
    public Long create(@RequestBody SubjectForm subjectForm) {
        return subjectService.create(subjectForm);
    }

    @PutMapping("")
    public Long update(@RequestBody SubjectForm subjectForm) {
        return subjectService.update(subjectForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subjectService.deleteById(id);
    }

    @GetMapping("/{id}")
    public SubjectVo getById(@PathVariable Long id) {
        var subject = subjectService.findByIdNN(id);

        return subjectConverter.subjectVoConverter().convert(subject);

    }

    @GetMapping("")
    public List<SubjectVo> getAll() {
        var subjects = subjectService.findAll();

        return subjects.stream()
                .map(subjectConverter.subjectVoConverter()::convert)
                .collect(Collectors.toList());
    }
}
