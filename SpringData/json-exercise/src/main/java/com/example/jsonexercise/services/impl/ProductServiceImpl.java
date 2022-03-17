package com.example.jsonexercise.services.impl;

import com.example.jsonexercise.model.dto.ProductSeedDto;
import com.example.jsonexercise.model.dto.ProductsNameAndPriceDto;
import com.example.jsonexercise.model.entity.Product;
import com.example.jsonexercise.repository.ProductRepository;
import com.example.jsonexercise.services.CategoryService;
import com.example.jsonexercise.services.ProductService;
import com.example.jsonexercise.services.UserService;
import com.example.jsonexercise.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.jsonexercise.constant.GlobalConstant.RESOURCES_FILE_PATH;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCTS_PATH = "products.json";
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, ProductRepository productRepository, UserService userService, CategoryService categoryService) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProducts() throws IOException {
        if (productRepository.count() > 0){
            return;
        }
        String fileContent = Files
                .readString(Path.of(RESOURCES_FILE_PATH + PRODUCTS_PATH));

        ProductSeedDto[] productSeedDtos = gson.fromJson(fileContent, ProductSeedDto[].class);

        Arrays.stream(productSeedDtos).filter(validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = modelMapper.map(productSeedDto,Product.class);
                    product.setSeller(userService.getRandomUser());
                    int flipCoinNum = ThreadLocalRandom.current().nextInt(1,11);
                    if (flipCoinNum % 2 == 0){
                        product.setBuyer(userService.getRandomUser());
                    }
                    product.setCategories(categoryService.getRandomCategories());
                    return product;
                }).forEach(productRepository::save);


    }

    @Override
    public List<ProductsNameAndPriceDto> findAllProductsWithPriceBetween(BigDecimal lower, BigDecimal upper) {
        return productRepository.findAllByPriceBetweenAndBuyerNullOrderByPriceDesc(lower,upper)
                .stream()
                .map(product -> {
                    ProductsNameAndPriceDto productsNameAndPriceDto = modelMapper.map(product,ProductsNameAndPriceDto.class);
                    productsNameAndPriceDto.setSeller(String.format("%s %s",
                            product.getSeller().getFirstName(),
                            product.getSeller().getLastName()));

                    return productsNameAndPriceDto;
                })
                .collect(Collectors.toList());

    }
}
