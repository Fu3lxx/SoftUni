package com.example.xmlexercise.service;

import com.example.xmlexercise.models.dto.productDto.ProductSeedDto;
import com.example.xmlexercise.models.dto.productDto.ProductViewRootDto;

import java.util.List;

public interface ProductService {

    Long getCount();

    void seedProducts(List<ProductSeedDto> products);

    ProductViewRootDto findProductsWithPriceBetweenWithNoBuyer();
}
