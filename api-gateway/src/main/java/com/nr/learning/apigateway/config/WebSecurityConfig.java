package com.nr.learning.apigateway.config;

import com.nr.learning.apigateway.security.TokenAuthenticationFilter;
import com.nr.learning.apigateway.security.TokenHelper;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by nishantr on 09/07/18.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  TokenHelper tokenHelper;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS ).and()
        .exceptionHandling().authenticationEntryPoint(
        (req,rsp,e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
        .authorizeRequests()
        .antMatchers("/order-service/**").access("hasRole('ROLE_USER')")
        .antMatchers("/product-service/**").access("hasRole('ROLE_USER')")
        .anyRequest().authenticated().and()
        .addFilterAfter(new TokenAuthenticationFilter(tokenHelper), UsernamePasswordAuthenticationFilter.class);

    http.csrf().disable();
  }

  @Override
  public void configure(WebSecurity web) {
    web.ignoring().antMatchers("/login-service/login/token");
  }
}
