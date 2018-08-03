package com.nr.learning.authservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by nishantr on 10/07/18.
 */
@Data
@NoArgsConstructor
public class AuthenticationRequest {
  private String username;
  private String password;
}
