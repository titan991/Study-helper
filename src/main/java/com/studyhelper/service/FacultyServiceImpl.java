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

@AllArgsConstructor
@Service
public class FacultyServiceImpl implements FacultyService{

    private final FacultyRepository facultyRepository;
    private final FacultyConverter facultyConverter;

    @Override
    public Faculty findByName(String name) throws NameNotFoundException {
        return facultyRepository.findByName(name)
                .orElseThrow(()-> new UsernameNotFoundException("faculty doesn't exist"));
    }

    @Override
    public Long create(FacultyForm facultyForm) {
        Faculty faculty = facultyConverter
            .facultyConverter()
            .convert(facultyForm);
        if (faculty == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Person not converted");
        }
        return facultyRepository.save(faculty).getId();
    }
}
