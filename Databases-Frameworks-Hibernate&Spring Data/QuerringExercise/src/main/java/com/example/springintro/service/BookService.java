package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int amountOfCopies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal priceLower, BigDecimal priceHigher);

    List<String> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate lower, LocalDate upper);

    List<String> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<String> findAllByTitleContains(String input);


    List<String> findAllTitleWithAuthorLastnameStartsWith(String startStr);

    int findAllBooksTitleWithLengthLongerThan(int titleLength);

    int findTotalCountOfAllBooksByAuthor(String firstName, String lastName);
}
