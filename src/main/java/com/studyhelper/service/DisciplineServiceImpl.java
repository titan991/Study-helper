package com.studyhelper.service;

import com.studyhelper.entity.converter.DisciplineConverter;
import com.studyhelper.entity.form.DisciplineForm;
import com.studyhelper.entity.merge_strategy.DepartmentMergeStrategy;
import com.studyhelper.entity.merge_strategy.DisciplineMergeStrategy;
import com.studyhelper.entity.models.Discipline;
import com.studyhelper.exceptions.ResponseException;
import com.studyhelper.jpa.DisciplineRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DisciplineServiceImpl implements DisciplineService {

    private final DisciplineRepository disciplineRepository;
    private final DisciplineConverter disciplineConverter;

    @Override
    public List<Discipline> findAll() {
        return disciplineRepository.findAll();
    }

    @Override
    public Discipline findByIdNN(Long id) {
        return disciplineRepository
                .findById(id)
                .orElseThrow(() -> new ResponseException(HttpStatus.BAD_REQUEST, "Faculty not found by id = " + id));
    }

    @Override
    public Long create(DisciplineForm disciplineForm) {
        var discipline = disciplineConverter.disciplineFormConverter().convert(disciplineForm);

        if(discipline==null){
            throw new ResponseException(HttpStatus.I_AM_A_TEAPOT, "discipline not found");
        }
        return disciplineRepository.save(discipline).getId();
    }

    @Override
    public Long update(DisciplineForm form) {
        return DisciplineService.super.update(form);
    }

    @Override
    public void deleteById(Long id) {
        disciplineRepository.deleteById(id);
    }
}
