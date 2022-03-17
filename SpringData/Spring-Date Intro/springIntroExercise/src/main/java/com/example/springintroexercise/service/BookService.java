package com.example.springintroexercise.service;


import com.example.springintroexercise.model.entity.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);
    List<String> findAllBooksBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstNameLastNameOrderByReleaseDate(String firstName,String lastName);
}
