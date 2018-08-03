package com.nr.learning.authservice.security;

import com.nr.learning.authservice.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Created by nishantr on 09/07/18.
 */
@Component
public class TokenHelper {

  @Value("${jwt.secret}")
  public String SECRET;

  private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;


  public String generateToken(Authentication authentication) {
    return Jwts.builder()
        .setSubject(authentication.getName())
        .claim("authorities",authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
        .setIssuedAt(new Date())
        .setExpiration(generateExpirationDate())
        .signWith( SIGNATURE_ALGORITHM, SECRET.getBytes() )
        .compact();
  }

  private Date generateExpirationDate() {
    return new Date(new Date().getTime() + (24 * 60 * 60 * 1000));
  }

}
