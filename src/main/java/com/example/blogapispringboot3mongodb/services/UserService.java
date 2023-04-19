package com.example.blogapispringboot3mongodb.services;

import com.example.blogapispringboot3mongodb.domain.User;
import com.example.blogapispringboot3mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
