package com.example.blogapispringboot3mongodb.resources;

import com.example.blogapispringboot3mongodb.domain.User;
import com.example.blogapispringboot3mongodb.dto.UserDTO;
import com.example.blogapispringboot3mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> userList = userService.findAll();
        List<UserDTO> userDTOList = userList.stream().map(user -> new UserDTO(user)).toList();
        return ResponseEntity.ok().body(userDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User userObj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(userObj));
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO userDTO) {
        User userObj = userService.fromDTO(userDTO);
        userObj = userService.insert(userObj);
        URI postUri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(userObj.getId())
            .toUri();
        return ResponseEntity.created(postUri).body(new UserDTO(userObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO userDTO) {
        User userObj = userService.fromDTO(userDTO);
        userObj = userService.update(id, userObj);
        return ResponseEntity.ok().body(new UserDTO(userObj));
    }
}
