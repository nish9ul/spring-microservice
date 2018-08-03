package com.nr.learning.authservice.rest;

import com.nr.learning.authservice.dto.ApiCreateUser;
import com.nr.learning.authservice.dto.ApiUser;
import com.nr.learning.authservice.dto.UserMapper;
import com.nr.learning.authservice.model.User;
import com.nr.learning.authservice.service.UserService;
import java.util.Collection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nishantr on 09/07/18.
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  private UserService userService;

  @PostMapping
 // @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  public ResponseEntity<ApiUser> createUser(@RequestBody ApiCreateUser createUser) {
    log.info("createUser " + createUser);
    createUser.setPassword(passwordEncoder().encode(createUser.getPassword()));
    return ResponseEntity.ok(UserMapper.INSTANCE.fromUser(userService.save(createUser)));
  }
}
