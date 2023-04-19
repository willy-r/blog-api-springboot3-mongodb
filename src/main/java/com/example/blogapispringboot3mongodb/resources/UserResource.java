package com.example.blogapispringboot3mongodb.resources;

import com.example.blogapispringboot3mongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User user1 = new User("1", "Maria Sila", "maria@gmail.com");
        User user2 = new User("2", "Alex Green", "alex@gmail.com");
        List<User> userList = new ArrayList<>();
        userList.addAll(Arrays.asList(user1, user2));
        return ResponseEntity.ok().body(userList);
    }
}
