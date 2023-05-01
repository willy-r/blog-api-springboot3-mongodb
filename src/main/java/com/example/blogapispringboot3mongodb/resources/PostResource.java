package com.example.blogapispringboot3mongodb.resources;

import com.example.blogapispringboot3mongodb.domain.Post;
import com.example.blogapispringboot3mongodb.domain.User;
import com.example.blogapispringboot3mongodb.dto.UserDTO;
import com.example.blogapispringboot3mongodb.resources.util.URL;
import com.example.blogapispringboot3mongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        List<Post> postList = postService.findAll();
        return ResponseEntity.ok().body(postList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post postObj = postService.findById(id);
        return ResponseEntity.ok().body(postObj);
    }

    @GetMapping(value = "/title-search")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> postList = postService.findByTitle(text);
        return ResponseEntity.ok().body(postList);
    }
}
