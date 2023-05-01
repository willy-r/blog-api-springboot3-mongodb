package com.example.blogapispringboot3mongodb.config;

import com.example.blogapispringboot3mongodb.domain.Post;
import com.example.blogapispringboot3mongodb.domain.User;
import com.example.blogapispringboot3mongodb.dto.AuthorDTO;
import com.example.blogapispringboot3mongodb.dto.CommentDTO;
import com.example.blogapispringboot3mongodb.repositories.PostRepository;
import com.example.blogapispringboot3mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
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
        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Post post1 = new Post(null, sdf.parse("21/03/2023"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(user1));
        Post post2 = new Post(null, sdf.parse("23/03/2023"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(user1));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(user2));
        CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new AuthorDTO(user3));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(user2));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        user1.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(user1);
    }
}
