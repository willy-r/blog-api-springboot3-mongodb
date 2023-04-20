package com.example.blogapispringboot3mongodb.repositories;

import com.example.blogapispringboot3mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
