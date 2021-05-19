package com.studyhelper.service;

import com.studyhelper.entity.converter.GroupConverter;
import com.studyhelper.entity.form.GroupForm;
import com.studyhelper.entity.models.Groupperson;
import com.studyhelper.jpa.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import javax.naming.NameNotFoundException;

@AllArgsConstructor
@Service
public class GroupServiceImpl implements GroupService{

    private final GroupRepository groupRepository;
    private final GroupConverter groupConverter;

    @Override
    public Groupperson findByName(String name) throws NameNotFoundException {
        return groupRepository.findByName(name)
                .orElseThrow(()-> new UsernameNotFoundException("group doesn't exist"));
    }

    @Override
    public Long create(GroupForm groupForm) {
        Groupperson groupperson =groupConverter
                .groupConverter()
                .convert(groupForm);

        if (groupperson == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Group not converted");
        }
        return groupRepository.save(groupperson).getId();
    }

}
