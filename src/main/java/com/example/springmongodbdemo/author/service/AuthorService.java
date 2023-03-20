package com.example.springmongodbdemo.author.service;

import com.example.springmongodbdemo.author.model.Author;
import com.example.springmongodbdemo.author.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Page<Author> getAuthors(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

    public Author getAuthorById(String id) {
        return authorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found by id: " + id));
    }

}
