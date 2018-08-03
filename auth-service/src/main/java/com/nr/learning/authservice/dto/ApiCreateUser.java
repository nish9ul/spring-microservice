package com.nr.learning.authservice.dto;

import com.nr.learning.authservice.model.AuthorityName;
import java.util.Collection;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by nishantr on 10/07/18.
 */
@Data
@NoArgsConstructor
public class ApiCreateUser {

  private String firstName;

  private String lastName;

  private String email;

  private String password;

  private Collection<AuthorityName> authorities;

}
