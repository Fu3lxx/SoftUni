package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType,int amountOfCopies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal priceLower, BigDecimal priceHigher);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate lower, LocalDate upper);

    List<Book> findAllByTitleContains(String input);

    List<Book> findAllByAuthor_LastNameStartsWith(String startStr);

    @Query("SELECT count (b) from Book b where length(b.title) > :param ")
    int findAllBooksTitleWithLengthLongerThan(@Param(value = "param") int titleLength);

    @Query ("SELECT sum (b.copies) as ccount " +
            "from Book b " +
            "where b.author.firstName = :firstName " +
            "and  b.author.lastName = :lastName " +
            "order by ccount desc ")
    int findTotalCountOfAllBooksByAuthor(@Param(value = "firstName") String firstName,
                                         @Param(value = "lastName") String lastName);



}
