package com.studyhelper.controller;

import com.studyhelper.entity.converter.DepartmentConverter;
import com.studyhelper.entity.converter.GroupConverter;
import com.studyhelper.entity.form.DepartmentForm;
import com.studyhelper.entity.form.GroupForm;
import com.studyhelper.entity.vo.DepartmentVo;
import com.studyhelper.entity.vo.GroupVo;
import com.studyhelper.service.DepartmentService;
import com.studyhelper.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequestMapping("/group")
@RestController
public class GroupController {

    private final GroupService groupService;
    private final GroupConverter groupConverter;

    @PostMapping("")
    public Long create(@RequestBody GroupForm groupForm) {
        return groupService.create(groupForm);
    }

    @PutMapping("")
    public Long update(@RequestBody GroupForm groupForm) {
        return groupService.update(groupForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        groupService.deleteById(id);
    }

    @GetMapping("/{id}")
    public GroupVo getById(@PathVariable Long id) {
        var group = groupService.findByIdNN(id);

        return groupConverter.groupVoConverter().convert(group);
    }

    @GetMapping("")
    public List<GroupVo> getAll() {
        var groups = groupService.findAll();

        return groups.stream()
                .map(groupConverter.groupVoConverter()::convert)
                .collect(Collectors.toList());
    }
}
