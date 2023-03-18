package com.example.springmongodbdemo;

import com.example.springmongodbdemo.author.model.Author;
import com.example.springmongodbdemo.author.repository.AuthorRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringMongodbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongodbDemoApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(AuthorRepository authorRepository) {
        return args -> {
            var authors = List.of(
                    new Author(null, "J.R.R.", "Tolkien"),
                    new Author(null, "Stephen", "King")
            );

            authorRepository.insert(authors);
        };
    }

}
