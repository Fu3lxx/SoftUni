package com.example.jsonexercise.services;

import com.example.jsonexercise.model.dto.ProductsNameAndPriceDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts() throws IOException;

    List<ProductsNameAndPriceDto> findAllProductsWithPriceBetween(BigDecimal lower, BigDecimal upper);
}
