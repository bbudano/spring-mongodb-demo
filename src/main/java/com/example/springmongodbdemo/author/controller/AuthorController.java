package com.example.springmongodbdemo.author.controller;

import com.example.springmongodbdemo.author.model.Author;
import com.example.springmongodbdemo.author.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public Author insertAuthor(@RequestBody Author author) {
        return authorService.insertAuthor(author);
    }

    @GetMapping
    public Page<Author> getAuthors(Pageable pageable) {
        return authorService.getAuthors(pageable);
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable String id) {
        return authorService.getAuthorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable String id) {
        authorService.deleteAuthor(id);
    }

}
