package com.example.blogapispringboot3mongodb.services;

import com.example.blogapispringboot3mongodb.domain.Post;
import com.example.blogapispringboot3mongodb.repositories.PostRepository;
import com.example.blogapispringboot3mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> postObj = postRepository.findById(id);
        return postObj.orElseThrow(() -> new ObjectNotFoundException("Object with identifier " + id + " not found."));
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitle(text);
    }

    public List<Post> findByFilters(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.findByFilters(text, minDate, maxDate);
    }
}
