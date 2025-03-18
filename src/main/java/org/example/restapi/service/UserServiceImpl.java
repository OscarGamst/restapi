package org.example.restapi.service;

import org.example.restapi.model.User;
import org.example.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements org.example.restapi.service.UserService {
    @Autowired
    private UserRepository userRepository;

    //  ------------------ GET ------------------
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    //  ------------------ SAVE ------------------
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //  ------------------ DELETE ------------------
    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    //  ------------------ PUT ------------------
    @Override
    public User updateUser(String username, User user) {
        return userRepository.findById(username)
                .map(existingUser -> {
                    existingUser.setEmail(user.getEmail());
                    existingUser.setPassword(user.getPassword()); // Hash the password if needed
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }

}
