package com.example.blogapispringboot3mongodb.config;

import com.example.blogapispringboot3mongodb.domain.Post;
import com.example.blogapispringboot3mongodb.domain.User;
import com.example.blogapispringboot3mongodb.repositories.PostRepository;
import com.example.blogapispringboot3mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "Maria Brown", "maria@gmail.com");
        User user2 = new User(null, "Alex Green", "alex@gmail.com");
        User user3 = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2023"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", user1);
        Post post2 = new Post(null, sdf.parse("23/03/2023"), "Bom dia", "Acordei feliz hoje!", user1);

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
