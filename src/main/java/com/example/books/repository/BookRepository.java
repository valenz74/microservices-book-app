package com.example.books.repository;

import com.example.books.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findAll();

    @Query("Select b from Book b join b.generos g where g = :gender")
    List<Book> findByGender(String gender);

    List<Book> findByAutor(String autor);
}
