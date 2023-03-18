package com.example.springmongodbdemo.author.repository;

import com.example.springmongodbdemo.author.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
