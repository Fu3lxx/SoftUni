package com.example.xmlexercise.service.impl;

import com.example.xmlexercise.models.dto.productDto.ProductSeedDto;
import com.example.xmlexercise.models.dto.productDto.ProductViewRootDto;
import com.example.xmlexercise.models.dto.productDto.ProductWithSellerDto;
import com.example.xmlexercise.models.entity.Product;
import com.example.xmlexercise.repository.ProductRepository;
import com.example.xmlexercise.service.CategoryService;
import com.example.xmlexercise.service.ProductService;
import com.example.xmlexercise.service.UserService;
import com.example.xmlexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CategoryService categoryService;
    private final UserService userService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, CategoryService categoryService, UserService userService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public Long getCount() {
        return this.productRepository.count();
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {
        products.stream().filter(validationUtil::isValid)
                .map(category-> {
                    Product product = modelMapper.map(category,Product.class);
                    product.setSeller(userService.getRandomUser());
                    int flipCoin = ThreadLocalRandom.current().nextInt(1,11);

                    if (flipCoin % 2 == 0){
                        product.setBuyer(userService.getRandomUser());
                    }

                    product.setCategories(categoryService.getRandomCategories());

                    return product;
                })
                .forEach(productRepository::save);
    }

    @Override
    public ProductViewRootDto findProductsWithPriceBetweenWithNoBuyer() {
        BigDecimal upper = BigDecimal.valueOf(1000);
        BigDecimal lower = BigDecimal.valueOf(500);

        ProductViewRootDto dto = new ProductViewRootDto();

        dto.setProducts(productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc(lower,upper)
                .stream().map(product -> {
                    ProductWithSellerDto productWithSellerDto = modelMapper.map(product, ProductWithSellerDto.class);
                    productWithSellerDto.setSeller(String.format("%s %s",product.getSeller().getFirstName(),product.getSeller().getLastName()));
                    return productWithSellerDto;
                })
                .collect(Collectors.toList()));


        return dto;
    }


}
