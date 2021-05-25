package com.studyhelper.service;

import com.studyhelper.entity.converter.PersonConverter;
import com.studyhelper.entity.form.PersonForm;
import com.studyhelper.entity.models.Person;
import com.studyhelper.exceptions.ResponseException;
import com.studyhelper.jpa.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonServiceImpl implements UserDetailsService, PersonService {

    private final PersonRepository personRepository;
    private final PersonConverter personConverter;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return personRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Person doesn't exist"));
    }

    @Override
    public List<Person> findAll() { return personRepository.findAll();
    }

    @Override
    public Person findByIdNN(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new ResponseException(HttpStatus.NOT_FOUND, "Person not found by id = " + id));
    }

    @Override
    public Long create(PersonForm form) {
        var person= personConverter.personFormConverter().convert(form);

        if(person==null){
            throw new ResponseException(HttpStatus.INTERNAL_SERVER_ERROR, "Person not found");
        }

        person.setPassword(bCryptPasswordEncoder.encode(form.getPassword()));

        return personRepository.save(person).getId();
    }

    @Override
    public Long update(PersonForm form) {
        return PersonService.super.update(form);
    }

    @Override
    public void deleteById(Long id) { personRepository.deleteById(id);
    }
}
