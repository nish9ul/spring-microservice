package com.nr.learning.authservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by nishantr on 10/07/18.
 */
@Data
@NoArgsConstructor
public class ApiUser {

  private String firstName;

  private String lastName;

  private String email;

}
