package com.nr.learning.authservice.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by nishantr on 03/07/18.
 */
@Entity
@Data
@Table(name = "[user]")
public class User implements Serializable, UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID userId;

  private String firstName;

  private String lastName;

  @Column(unique = true, nullable = false)
  private String email;

  private String password;

  @ElementCollection(targetClass = AuthorityName.class, fetch = FetchType.EAGER)
  @Enumerated(EnumType.STRING)
  private Collection<AuthorityName> authorities;

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
