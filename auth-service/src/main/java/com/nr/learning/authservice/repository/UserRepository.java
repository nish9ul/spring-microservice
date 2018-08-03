package com.nr.learning.authservice.repository;

import com.nr.learning.authservice.model.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nishantr on 09/07/18.
 */
public interface UserRepository extends JpaRepository<User, UUID> {

  User findByEmail(String username);

}