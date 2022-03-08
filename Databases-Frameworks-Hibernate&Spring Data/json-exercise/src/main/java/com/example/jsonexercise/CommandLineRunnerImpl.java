package com.example.jsonexercise;

import com.example.jsonexercise.model.dto.ProductsNameAndPriceDto;
import com.example.jsonexercise.model.dto.UserSoldDto;
import com.example.jsonexercise.services.CategoryService;
import com.example.jsonexercise.services.ProductService;
import com.example.jsonexercise.services.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private static final String OUTPUT_PATH = "src/main/resources/files/out/";
    public static final String PRODUCT_IN_RANGE_FILE_NAME = "product-in-range.json";
    public static final String USERS_WITH_MORE_THAN_ONE_SELL = "users-with-more-than-one-sell";

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final Scanner scanner;
    private final Gson gson;

    public CommandLineRunnerImpl(CategoryService categoryService, UserService userService, ProductService productService, Gson gson) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.gson = gson;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        System.out.println("Enter exercise number:");
        int exerciseNum = Integer.parseInt(scanner.nextLine());
        
        switch (exerciseNum){
            case 1 -> executeExercise1();
            case 2 -> executeExercise2();
        }

    }

    private void executeExercise2() throws IOException {

        List<UserSoldDto> users = userService.findAllUsersWithMoreThanOneSoldProductOrdered();
        String gsonData = gson.toJson(users);
        writeToFile(OUTPUT_PATH + USERS_WITH_MORE_THAN_ONE_SELL, gsonData);
    }

    private void executeExercise1() throws IOException {
        //Products in Range
        List<ProductsNameAndPriceDto> productsDtos = productService
                .findAllProductsWithPriceBetween(BigDecimal.valueOf(500L),BigDecimal.valueOf(1000L));

        String gsonData = gson.toJson(productsDtos);

        writeToFile(OUTPUT_PATH + PRODUCT_IN_RANGE_FILE_NAME, gsonData);

    }

    private void writeToFile(String path, String gsonData) throws IOException {
        Files.write(Path.of(path), Collections.singleton(gsonData));
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        userService.seedUsers();
        productService.seedProducts();
    }
}
