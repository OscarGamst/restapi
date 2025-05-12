package org.example.restapi.repository;

import org.example.restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


    User findUserByUsername(String username);
    void deleteByUsername(String username);

    Optional<User> findByUsername(String username);
}
