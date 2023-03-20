package com.example.springmongodbdemo;

import com.example.springmongodbdemo.author.model.Author;
import com.example.springmongodbdemo.author.model.PersonalInfo;
import com.example.springmongodbdemo.author.repository.AuthorRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SpringMongodbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongodbDemoApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(AuthorRepository authorRepository) {
        return args -> {
            authorRepository.deleteAll();

            var authors = List.of(
                    new Author(null, new PersonalInfo("J.R.R.", "Tolkien", LocalDate.of(1892, 1, 3))),
                    new Author(null, new PersonalInfo("Stephen", "King", LocalDate.of(1974, 9, 21)))
            );

            authorRepository.insert(authors);
        };
    }

}
