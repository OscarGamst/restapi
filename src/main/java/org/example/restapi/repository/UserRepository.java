package org.example.restapi.repository;

import aj.org.objectweb.asm.commons.Remapper;
import org.example.restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


}
