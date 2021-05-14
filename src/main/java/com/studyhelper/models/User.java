package com.studyhelper.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;


@Getter
@Setter
@Entity
@Table
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String username;
    @Column
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

