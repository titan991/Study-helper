package com.studyhelper.service;

import com.studyhelper.entity.converter.PersonConverter;
import com.studyhelper.entity.form.PersonForm;
import com.studyhelper.entity.models.Person;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.studyhelper.jpa.PersonRepository;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class PersonServiceImpl implements UserDetailsService, PersonService {

    private final PersonRepository personRepository;
    private final PersonConverter personConverter;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return personRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User doesn't exist"));
    }

    @Override
    public Long create(PersonForm personForm) {
        Person person = personConverter
            .personConverter()
            .convert(personForm);

        if (person == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Person not converted");
        }

        person.setPassword(passwordEncoder.encode(personForm.getPassword()));

        return personRepository.save(person).getId();
    }
}
