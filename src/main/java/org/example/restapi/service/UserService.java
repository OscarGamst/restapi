package org.example.restapi.service;

import org.example.restapi.model.User;
import org.springframework.stereotype.Service;

import java.util.*;


public interface UserService {

    // ----------------- ALL GETS -----------------


    // ----------------- ALL CREATE -----------------
    void createUser(User user);


    // ----------------- ALL DELETES -----------------

    // ----------------- ALL UPDATES -----------------
    User updateUser(String username, User updatedUser);


}
