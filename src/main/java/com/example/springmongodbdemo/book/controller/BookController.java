package com.example.springmongodbdemo.book.controller;

import com.example.springmongodbdemo.book.model.Book;
import com.example.springmongodbdemo.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public Book insertBook(@RequestBody Book book) {
        return bookService.insertBook(book);
    }

    @GetMapping
    public Page<Book> getBooks(Pageable pageable) {
        return bookService.getBooks(pageable);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }

}
