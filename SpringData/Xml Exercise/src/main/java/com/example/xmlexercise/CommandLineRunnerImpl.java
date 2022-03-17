package com.example.xmlexercise;

import com.example.xmlexercise.models.dto.categoryDto.CategorySeedRootDto;
import com.example.xmlexercise.models.dto.productDto.ProductSeedRootDto;
import com.example.xmlexercise.models.dto.productDto.ProductViewRootDto;
import com.example.xmlexercise.models.dto.userDto.UserSeedRootDto;
import com.example.xmlexercise.models.dto.userDto.UserViewRootDto;
import com.example.xmlexercise.service.CategoryService;
import com.example.xmlexercise.service.ProductService;
import com.example.xmlexercise.service.UserService;
import com.example.xmlexercise.util.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl  implements CommandLineRunner {

    private static final String FILES_PATH = "src/main/resources/files/";
    private static final String CATEGORY_PATH = "categories.xml";
    private static final String USER_PATH = "users.xml";
    private static final String PRODUCT_PATH = "products.xml";
    private static final String OUTPUT_PATH = "output/";

    private static final String PRODUCT_IN_RANGE = "products-in-range.xml";


    private final XmlParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final Scanner scanner;

    public CommandLineRunnerImpl(XmlParser xmlParser, CategoryService categoryService, UserService userService, ProductService productService) {
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();
        System.out.println("Enter exercise number:");
        int exerciseNum = Integer.parseInt(scanner.nextLine());
        
        switch (exerciseNum){
            case 1 -> runExercise1();
            case 2 -> runExercise2();
        }

    }

    private void runExercise2() {
        UserViewRootDto viewRootDto = userService.findUserWithMoreThanOneSoldProducts();
        System.out.println("2");
    }

    private void runExercise1() throws JAXBException {
        ProductViewRootDto rootDto = productService.findProductsWithPriceBetweenWithNoBuyer();

        xmlParser.toFile(FILES_PATH + OUTPUT_PATH + PRODUCT_IN_RANGE,rootDto);

    }

    private void seedData() throws JAXBException, FileNotFoundException {
        if (categoryService.getCount() == 0){
            CategorySeedRootDto categorySeedRootDto =
                    xmlParser.fromFile(FILES_PATH + CATEGORY_PATH, CategorySeedRootDto.class);
            categoryService.seedCategories(categorySeedRootDto.getCategories());
        }

        if (userService.getCount() == 0){
            UserSeedRootDto userSeedRootDto = xmlParser
                    .fromFile(FILES_PATH + USER_PATH, UserSeedRootDto.class);

            userService.seedUsers(userSeedRootDto.getUsers());
        }

        if (productService.getCount() == 0){

            ProductSeedRootDto productSeedRootDto = xmlParser
                    .fromFile(FILES_PATH + PRODUCT_PATH, ProductSeedRootDto.class);


            productService.seedProducts(productSeedRootDto.getProducts());
        }

    }
}
