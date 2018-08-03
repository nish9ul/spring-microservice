package com.nr.learning.authservice.service.impl;

import com.nr.learning.authservice.dto.ApiCreateUser;
import com.nr.learning.authservice.dto.UserMapper;
import com.nr.learning.authservice.model.User;
import com.nr.learning.authservice.repository.UserRepository;
import com.nr.learning.authservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by nishantr on 10/07/18.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;


  public User save(ApiCreateUser apiUser) {
    return userRepository.save(UserMapper.INSTANCE.toUser(apiUser));
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    log.info("Getting user for username {}", username);
    return userRepository.findByEmail(username);
  }
}
