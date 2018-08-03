package com.nr.learning.apigateway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by nishantr on 09/07/18.
 */
@Component
public class TokenHelper {

  @Value("${jwt.secret}")
  public String SECRET;

  @Value("${jwt.header}")
  private String AUTH_HEADER;

  private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

  public Claims getAllClaimsFromToken(String token) {
    Claims claims;
    try {
      claims = Jwts.parser()
          .setSigningKey(SECRET.getBytes())
          .parseClaimsJws(token)
          .getBody();
    } catch (Exception e) {
      e.printStackTrace();
      claims = null;
    }
    return claims;
  }

  public String getToken( HttpServletRequest request ) {
    /**
     *  Getting the token from Authentication header
     *  e.g Bearer your_token
     */
    String authHeader = getAuthHeaderFromHeader( request );
    if ( authHeader != null && authHeader.startsWith("Bearer ")) {
      return authHeader.substring(7);
    }

    return null;
  }

  private String getAuthHeaderFromHeader( HttpServletRequest request ) {
    return request.getHeader(AUTH_HEADER);
  }

}
