package org.example.restapi.repository;

import org.example.restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAll();

    User getUserByUsername(String username);
}
