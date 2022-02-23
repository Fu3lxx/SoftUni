package com.example.advquerying.services;

import com.example.advquerying.entities.Label;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooServices {
    List<Shampoo> findAllBySizeOrderById (Size size);
    List<Shampoo> findAllBySizeOrLabelIdOrderByPrice(Size size, Long labelId);
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);
    int countAllByPriceIsLessThan(BigDecimal price);
    List<String> findAllByIngredientsNames(List<String> names);
    List<String> findAllByShampooIngredientsCountLessThan(Long ingCount);
}
