package com.studyhelper.service;

import com.studyhelper.entity.converter.DepartmentConverter;
import com.studyhelper.entity.form.DepartmentForm;
import com.studyhelper.entity.merge_strategy.DepartmentMergeStrategy;
import com.studyhelper.entity.models.Department;
import com.studyhelper.exceptions.ResponseException;
import com.studyhelper.jpa.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentConverter departmentConverter;
    private final DepartmentMergeStrategy mergeStrategy;

    @Override
    public List<Department> findAll() { return departmentRepository.findAll();
    }

    @Override
    public Department findByIdNN(Long id) {
        return departmentRepository
                .findById(id)
                .orElseThrow(() -> new ResponseException(HttpStatus.BAD_REQUEST, "Faculty not found by id = " + id));
    }

    @Override
    public Long create(DepartmentForm departmentForm) {
        var department = departmentConverter.departmentFormConverter().convert(departmentForm);

        if (department == null) {
            throw new ResponseException(HttpStatus.I_AM_A_TEAPOT, "department not found");
        }

        return departmentRepository.save(department).getId();
    }

    @Override
    public Long update(DepartmentForm departmentForm) {
        var department = findByIdNN(departmentForm.getId());

        department = mergeStrategy.update(department, departmentForm);

        return departmentRepository.save(department).getId();
    }

    @Override
    public void deleteById(Long id) { departmentRepository.deleteById(id);
    }
}
