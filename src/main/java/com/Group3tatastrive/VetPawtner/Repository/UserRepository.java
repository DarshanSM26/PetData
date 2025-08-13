package com.Group3tatastrive.VetPawtner.Repository;

import com.Group3tatastrive.VetPawtner.Entity.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);

}
