package com.nr.learning.apigateway.security;

import io.jsonwebtoken.Claims;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Created by nishantr on 09/07/18.
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

  private final Log logger = LogFactory.getLog(this.getClass());

  private TokenHelper tokenHelper;

  public TokenAuthenticationFilter(TokenHelper tokenHelper) {
    this.tokenHelper = tokenHelper;
  }

  @Override
  public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    String authToken = tokenHelper.getToken(request);

    if (authToken != null) {

      try {
        Claims claims = tokenHelper.getAllClaimsFromToken(authToken);

        String username = claims.getSubject();
        List<String> authorities = claims.get("authorities", List.class);

        if (username != null) {
          UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, authorities.stream()
              .map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

          SecurityContextHolder.getContext().setAuthentication(auth);
        }
      } catch (Exception e) {
        SecurityContextHolder.clearContext();
        throw new AuthenticationServiceException("Invalid Token");
      }
    } else {
      throw new AuthenticationServiceException("Token is not provided");

    }
    chain.doFilter(request, response);
  }

}