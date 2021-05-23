package com.studyhelper.entity.vo;

import com.studyhelper.entity.models.Role;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonVo {
    private Long id;
    private String fullName;
    private String password;
    private String username;
    private Role role;
}
