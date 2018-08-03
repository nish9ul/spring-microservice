package com.nr.learning.authservice.model;

import java.io.Serializable;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by nishantr on 09/07/18.
 */
public enum AuthorityName implements GrantedAuthority {
  ROLE_USER,
  ROLE_ADMIN;

  @Override
  public String getAuthority() {
    return this.name();
  }
}
