package com.nr.learning.authservice.rest;

import com.nr.learning.authservice.dto.ApiCreateUser;
import com.nr.learning.authservice.dto.ApiUser;
import com.nr.learning.authservice.dto.AuthenticationRequest;
import com.nr.learning.authservice.dto.UserMapper;
import com.nr.learning.authservice.model.User;
import com.nr.learning.authservice.security.TokenHelper;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nishantr on 10/07/18.
 */
@RestController
@RequestMapping(value = "/login")
@Slf4j
public class LoginController {

  @Autowired
  TokenHelper tokenHelper;

  @GetMapping("/token")
  public ResponseEntity getToken(Authentication authentication) {
    log.info("getToken, authentication : " + authentication);
    return ResponseEntity.ok(tokenHelper.generateToken( authentication));
  }

 /* @Autowired
  private AuthenticationManager authenticationManager;

  @PostMapping("/token-jwt")
  public ResponseEntity<?> getAuthenticationToken(
      @RequestBody AuthenticationRequest authenticationRequest,
      HttpServletResponse response
  ) throws AuthenticationException, IOException {

    log.info("Attempting login for user {} ", authenticationRequest.getUsername()  );
    // Perform the security
    try {
      final Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              authenticationRequest.getUsername(),
              authenticationRequest.getPassword()
          )
      );

    log.info("getAuthenticationToken, authentication : " + authentication);


    // Inject into security context
    SecurityContextHolder.getContext().setAuthentication(authentication);

    // token creation
    String jws = tokenHelper.generateToken( authentication);
    // Return the token
    return ResponseEntity.ok(jws);
    }catch (Exception e){
      log.error("Error",e);
      return ResponseEntity.badRequest().build();
    }
  }

*/
}
