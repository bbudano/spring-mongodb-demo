package com.example.springmongodbdemo;

import com.example.springmongodbdemo.author.model.Author;
import com.example.springmongodbdemo.author.model.PersonalInfo;
import com.example.springmongodbdemo.author.repository.AuthorRepository;
import com.example.springmongodbdemo.book.model.Book;
import com.example.springmongodbdemo.book.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class SpringMongodbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongodbDemoApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {
            authorRepository.deleteAll();
            bookRepository.deleteAll();

            var tolkien = authorRepository.insert(new Author(new PersonalInfo("J.R.R.", "Tolkien", LocalDate.of(1892, 1, 3))));
            var king = authorRepository.insert(new Author(new PersonalInfo("Stephen", "King", LocalDate.of(1974, 9, 21))));

            bookRepository.insert(new Book("Silmarillion", tolkien.getId()));
            bookRepository.insert(new Book("Misery", king.getId()));
        };
    }

}
