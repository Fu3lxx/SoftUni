package com.example.springintroexercise;

import com.example.springintroexercise.model.entity.Book;
import com.example.springintroexercise.service.AuthorService;
import com.example.springintroexercise.service.BookService;
import com.example.springintroexercise.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();

        //printAllBooksAfter2000(2000);
        //printAllAuthorsNamesWithBooksWithReleaseDateBefore1990(1990);
        //printAllAuthorsAndNumberOfTheirBooks();
        //printAllBooksByAuthorNameOrderByReleaseDate("George","Powell");


    }

    private void printAllBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService.findAllBooksByAuthorFirstNameLastNameOrderByReleaseDate(firstName,lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService.getAllAuthorsOrderByCountOfBooks().forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBefore1990(int year) {
        bookService.findAllBooksBeforeYear(year).forEach(System.out::println);
    }

    private void printAllBooksAfter2000(int year) {
        bookService.findAllBooksAfterYear(year).stream().map(Book::getTitle).forEach(System.out::println);
    }
    
}
