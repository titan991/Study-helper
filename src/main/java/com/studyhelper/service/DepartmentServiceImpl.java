package com.studyhelper.service;

import com.studyhelper.entity.models.Department;
import com.studyhelper.jpa.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department findByName(String name) throws NameNotFoundException {
        return departmentRepository.findByName(name)
                .orElseThrow(()->new UsernameNotFoundException("chair doesn't exist"));
    }
}
