package com.studyhelper.service;

import com.studyhelper.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.studyhelper.jpa.UserDAO;

@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDAO.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("User doesn't exist"));
    }
}
