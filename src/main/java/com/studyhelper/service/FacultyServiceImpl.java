package com.studyhelper.service;


import com.studyhelper.entity.converter.FacultyConverter;
import com.studyhelper.entity.form.FacultyForm;
import com.studyhelper.entity.merge_strategy.FacultyMergeStrategy;
import com.studyhelper.entity.models.Faculty;
import com.studyhelper.exceptions.ResponseException;
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
    private final FacultyConverter converter;
    private final FacultyMergeStrategy mergeStrategy;

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty findByIdNN(Long id) {
        return facultyRepository
            .findById(id)
            .orElseThrow(() -> new ResponseException(HttpStatus.BAD_REQUEST, "Faculty not found by id = " + id));
    }

    @Override
    public Long create(FacultyForm facultyForm) {
        var faculty = converter.facultyFormConverter().convert(facultyForm);

        if (faculty == null) {
            throw new ResponseException(HttpStatus.I_AM_A_TEAPOT, "faculty not found");
        }

        return facultyRepository.save(faculty).getId();
    }

    @Override
    public Long update(FacultyForm facultyForm) {
        var faculty = findByIdNN(facultyForm.getId());

        faculty = mergeStrategy.update(faculty, facultyForm);

        return facultyRepository.save(faculty).getId();
    }

    @Override
    public void deleteById(Long id) {
        facultyRepository.deleteById(id);
    }
}
