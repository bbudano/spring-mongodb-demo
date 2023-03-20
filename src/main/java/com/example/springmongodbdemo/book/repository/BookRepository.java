package com.example.springmongodbdemo.book.repository;

import com.example.springmongodbdemo.book.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
