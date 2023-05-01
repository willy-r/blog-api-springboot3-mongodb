package com.example.blogapispringboot3mongodb.repositories;

import com.example.blogapispringboot3mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> customFindByTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);
}
