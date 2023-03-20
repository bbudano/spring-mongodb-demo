package com.example.springmongodbdemo.book.service;

import com.example.springmongodbdemo.book.model.Book;
import com.example.springmongodbdemo.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book insertBook(Book book) {
        return bookRepository.insert(book);
    }

    public Page<Book> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public Book getBookById(String id) {
        return bookRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found by id: " + id));
    }

    public void deleteBook(String id) {
        var book = getBookById(id);

        bookRepository.delete(book);
    }

}
