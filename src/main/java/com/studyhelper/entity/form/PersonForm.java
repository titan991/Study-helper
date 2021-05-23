package com.studyhelper.entity.form;

import com.studyhelper.entity.models.Role;
import lombok.Data;

@Data
public class PersonForm {
  private Long id;
  private String fullname;
  private String username;
  private String password;
  private Role role;

}
