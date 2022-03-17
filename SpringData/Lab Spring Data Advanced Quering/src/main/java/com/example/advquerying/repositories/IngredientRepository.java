package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
    List<Ingredient> findAllByNameIsStartingWith(String letter);
    List<Ingredient> findAllByNameIsInOrderByPrice(List<String> names);


    @Query("delete FROM Ingredient i where i.name = :name")
    @Modifying
    void deleteAllByName(String name);

    @Query("update Ingredient i set i.price = i.price * 1.1")
    @Modifying
    void updatePrice();

    @Query ("update Ingredient i Set i.price = i.price * :priceChange where i.name in :names")
    @Modifying
    void updatePriceOfWith(List<String> names, BigDecimal priceChange);

}

