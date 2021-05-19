package com.studyhelper.service;


import com.studyhelper.entity.converter.FacultyConverter;
import com.studyhelper.entity.form.FacultyForm;
import com.studyhelper.entity.models.Faculty;
import com.studyhelper.jpa.FacultyRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.naming.NameNotFoundException;
import java.util.List;

@AllArgsConstructor
@Service
public class FacultyServiceImpl implements FacultyService{

    private final FacultyRepository facultyRepository;

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }
}
