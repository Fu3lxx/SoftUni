package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final Scanner scanner;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, Scanner scanner) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        //printAllBooksAfterYear(2000);
        //printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        //printAllAuthorsAndNumberOfTheirBooks();
        //printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");


        System.out.println("Enter exercise number:");
        int exerciseNum = Integer.parseInt(scanner.nextLine());
        switch (exerciseNum){
            case 1 -> runExercise1();
            case 2 -> runExercise2();
            case 3 -> runExercise3();
            case 4 -> runExercise4();
            case 5 -> runExercise5();
            case 6 -> runExercise6();
            case 7 -> runExercise7();
            case 8 -> runExercise8();
            case 9 -> runExercise9();
            case 10 -> runExercise10();
        }

    }

    private void runExercise10() {
        System.out.println("Enter author full name:");
        String[] fullName = scanner.nextLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        int totalCopiesOfBoosByAuthor = bookService.findTotalCountOfAllBooksByAuthor(firstName,lastName);

        System.out.printf("%s %s - %d%n",firstName,lastName,totalCopiesOfBoosByAuthor);
    }

    private void runExercise9() {
        System.out.println("Enter title length");
        int titleLength = Integer.parseInt(scanner.nextLine());
        int booksWithTitleLongerThan = bookService.findAllBooksTitleWithLengthLongerThan(titleLength);
        System.out.println(booksWithTitleLongerThan);
        System.out.printf("There are %d books with longer title than %d symbols%n",booksWithTitleLongerThan,titleLength);
    }

    private void runExercise8() {
        System.out.println("Enter Author last name starts with:");
        String startStr = scanner.nextLine();

        bookService.findAllTitleWithAuthorLastnameStartsWith(startStr)
                .forEach(System.out::println);
    }

    private void runExercise7() {
        System.out.println("Enter what should contains the title");
        String contains  = scanner.nextLine();

        bookService.findAllByTitleContains(contains).forEach(System.out::println);
    }

    private void runExercise6() {
        System.out.println("Enter how should ends first name");
        String substring = scanner.nextLine();

        authorService.findAllByFirstNameEndsWith(substring).forEach(System.out::println);
    }

    private void runExercise5() {
        System.out.println("Enter year:");
        String[] dateRaw = scanner.nextLine().split("-");
        int year = Integer.parseInt(dateRaw[2]);
        int month = Integer.parseInt(dateRaw[1]);
        int day = Integer.parseInt(dateRaw[0]);
        LocalDate date = LocalDate.of(year,month,day);

        bookService.findAllByReleaseDateBefore(date).forEach(System.out::println);
    }

    private void runExercise4() {
        System.out.println("Enter year:");
        int year = Integer.parseInt(scanner.nextLine());
        LocalDate lower = LocalDate.of(year,1,1);
        LocalDate upper = LocalDate.of(year,12,31);

        bookService.findAllByReleaseDateBeforeOrReleaseDateAfter(lower,upper).forEach(System.out::println);
    }

    private void runExercise3() {
        BigDecimal priceLower = BigDecimal.valueOf(5);
        BigDecimal priceHigher = BigDecimal.valueOf(40);

        bookService.findAllByPriceLessThanOrPriceGreaterThan(priceLower,priceHigher)
                .stream()
                .map(book -> String.format("%s - $%.2f",book.getTitle(),book.getPrice()))
                .forEach(System.out::println);

    }

    private void runExercise2() {
        int bookCopies = 5000;
        EditionType editionType = EditionType.valueOf("GOLD");
        bookService.findAllByEditionTypeAndCopiesLessThan(editionType,bookCopies)
                .forEach(System.out::println);
    }

    private void runExercise1() {
        System.out.println("Enter age restriction");
        String typeRestriction = scanner.nextLine().toUpperCase(Locale.ROOT);
        AgeRestriction ageRestriction = AgeRestriction.valueOf(typeRestriction);
        bookService.findAllByAgeRestriction(ageRestriction).forEach(System.out::println);
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
