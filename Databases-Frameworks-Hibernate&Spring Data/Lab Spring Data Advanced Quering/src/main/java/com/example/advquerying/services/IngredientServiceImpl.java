package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.math.BigDecimal;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAllByNameIsStartingWith(String letter) {
        return this.ingredientRepository.findAllByNameIsStartingWith(letter);
    }

    @Override
    public List<Ingredient> findAllByNameIsInOrderByPrice(List<String> names) {
        return this.ingredientRepository.findAllByNameIsInOrderByPrice(names);
    }

    @Override
    @Transactional
    public void deleteAllByName(String name) {
        this.ingredientRepository.deleteAllByName(name);
    }

    @Override
    @Transactional
    public void updatePrice() {
        this.ingredientRepository.updatePrice();
    }

    @Override
    @Transactional
    public void updatePriceOfWith(List<String> names, BigDecimal priceChange) {
        this.ingredientRepository.updatePriceOfWith(names,priceChange);
    }
}
