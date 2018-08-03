package com.nr.learning.authservice.service;

import com.nr.learning.authservice.dto.ApiCreateUser;
import com.nr.learning.authservice.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by nishantr on 10/07/18.
 */
public interface UserService extends UserDetailsService{

  public User save(ApiCreateUser apiUser);

}
