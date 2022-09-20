package com.esc.micro.kiwi.core.repositories.user;

import com.esc.micro.kiwi.core.model.common.user.User;
import com.esc.micro.kiwi.core.model.common.utils.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Optional<User> findByEmail(String email);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  @Query("select u from User u where u.status = ?1")
  Set<User> getAllByStatus();

  Optional<User> findByUsernameOrEmail(String username, String email);

  default User getUserByName(String username) {
    final Optional<User> currentUser = findByUsername(username);
    return currentUser.orElseThrow(() -> new ResourceNotFoundException("user", "username", username));

  }

  Optional<User> findById(Long id);
}
