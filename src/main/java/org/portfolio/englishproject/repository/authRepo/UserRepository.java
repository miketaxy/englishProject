package org.portfolio.englishproject.repository.authRepo;

import org.portfolio.englishproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> getUserByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);
}
