package com.example.springintroexercise.repository;

import com.example.springintroexercise.model.entity.Author;
import com.example.springintroexercise.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDate);
    List<Book> findAllByReleaseDateBefore(LocalDate releaseDate);
    List <Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle
            (String author_firstName, String author_lastName);

}
