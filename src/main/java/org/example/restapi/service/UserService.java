package org.example.restapi.service;

import org.example.restapi.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface UserService {

    //  ------------------ GET------------------
    List<User> getAllUsers();
    User getUserByUsername(String username);
    //  ------------------ SAVE ------------------
    User createUser(User user);

    //  ------------------ DELETE ------------------
    void deleteUser(String username);

    //  ------------------ PUT ------------------
    User updateUser(String username, User user);

}
