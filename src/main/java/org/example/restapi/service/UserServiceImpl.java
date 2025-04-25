package org.example.restapi.service;

import org.example.restapi.model.User;
import org.example.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // ----------------- ALL CREATE -----------------
    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    // ----------------- ALL UPDATES -----------------
    public User updateUser(String username, User updatedUser) {
        return userRepository.findById(username).map(user -> {
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }
}
