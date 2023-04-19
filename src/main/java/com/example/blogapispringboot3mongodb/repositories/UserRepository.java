package com.example.blogapispringboot3mongodb.repositories;

import com.example.blogapispringboot3mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
