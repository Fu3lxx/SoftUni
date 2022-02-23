package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientService {
    List<Ingredient> findAllByNameIsStartingWith(String letter);
    List<Ingredient> findAllByNameIsInOrderByPrice(List<String> names);
    void deleteAllByName(String name);
    void updatePrice();
    void updatePriceOfWith(List<String> names, BigDecimal priceChange);
}
