package org.example.restapi.controller;

import jakarta.validation.Valid;
import org.example.restapi.dto.UserBasicDTO;
import org.example.restapi.dto.UserDetailedDTO;
import org.example.restapi.mapper.UserMapper;
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
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper =userMapper;
    }
    // ----------------- ALL GETS -----------------
    //Basic user info
    @GetMapping("/basic")
    public ResponseEntity<List<UserBasicDTO>> getAllUsers() {
        List<User> users = userService.getUsers();
        List<UserBasicDTO> dtos = userMapper.usersToUserBasicDTOs(users);
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("/basic/{username}")
    public ResponseEntity<UserBasicDTO> getUserBasic(@PathVariable String username) {
        User user = userService.getUser(username);
        UserBasicDTO dto = userMapper.userToUserBasicDTO(user);
        return ResponseEntity.ok(dto);
    }

    //Detailed user info
    @GetMapping("/detailed")
    public ResponseEntity<List<UserDetailedDTO>> getUserDetailed() {
        List<User> users = userService.getUsers();
        List<UserDetailedDTO> dtos = userMapper.usersToUserDetailedDTOs(users);
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("/detailed/{username}")
    public ResponseEntity<UserDetailedDTO> getUserDetailed(@PathVariable String username) {
        User user = userService.getUser(username);
        UserDetailedDTO dto = userMapper.userToUserDetailedDTO(user);
        return ResponseEntity.ok(dto);
    }
    // ----------------- ALL POSTS -----------------
    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    // ----------------- ALL DELETES -----------------
    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userService.deleteUserByUsername(username);
        return ResponseEntity.noContent().build();
    }

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


