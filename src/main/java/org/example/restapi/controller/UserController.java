package org.example.restapi.controller;

import jakarta.validation.Valid;
import org.example.restapi.dto.UserDetailedDTO;
import org.example.restapi.model.User;
import org.example.restapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // ----------------- ALL GETS -----------------
    //Basic user info

    //Detailed user info
    // ----------------- ALL POSTS -----------------
    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    // ----------------- ALL DELETES -----------------

    // ----------------- ALL UPDATES -----------------
    @PutMapping("/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User updatedUser) {
        try {
            User user = userService.updateUser(username, updatedUser);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
