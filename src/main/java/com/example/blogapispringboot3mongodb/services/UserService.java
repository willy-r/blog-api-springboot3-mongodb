package com.example.blogapispringboot3mongodb.services;

import com.example.blogapispringboot3mongodb.domain.User;
import com.example.blogapispringboot3mongodb.repositories.UserRepository;
import com.example.blogapispringboot3mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> userObj = userRepository.findById(id);
        return userObj.orElseThrow(() -> new ObjectNotFoundException("Object with identifier " + id + " not found."));
    }
}
