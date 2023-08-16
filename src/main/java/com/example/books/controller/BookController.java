package com.example.books.controller;

import com.example.books.model.Book;
import com.example.books.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class BookController {

    private BookRepository bookRepository;

    @GetMapping("/")
    public List<Book> getAllBooks(@RequestParam(required = false) String gender,
                                  @RequestParam(required = false) String autor) {
        List<Book> books = null;
        if (gender != null && !gender.isBlank()) {
            books = this.bookRepository.findByGender(gender);
        }
        if (autor != null && !autor.isBlank()) {
            if (books != null && !books.isEmpty()) {
                books = books.stream().filter(book -> book.getAutor().equals(autor)).collect(Collectors.toList());
            } else {
                books = this.bookRepository.findByAutor(autor);
            }
        }

        if (books == null) return this.bookRepository.findAll();
        return books;
    }

    @PostMapping("/")
    public Book createBook(@RequestBody Book book) {
        if (book.getGeneros() == null) {
            List<String> generos = new ArrayList<>();
            book.setGeneros(generos);
        }
        return this.bookRepository.save(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id) {
        return this.bookRepository.findById(id).orElse(null);
    }

}
