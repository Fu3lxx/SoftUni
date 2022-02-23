package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {
    private final ShampooServices shampooServices;
    private final IngredientService ingredientService;
    private Scanner scanner;

    public Main(ShampooServices shampooServices, IngredientService ingredientService) {
        this.shampooServices = shampooServices;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        scanner = new Scanner(System.in);
        //runTask1();
        //runTask2();
        //runTask3();
        //runTask4();
        //runTask5();
        //runTask6();
        //runTask7();
        //runTask8();
        //runTask9();
        //runTask10();
        //runTask11();

    }

    private void runTask11() {
        System.out.println("Enter ingredients names:");
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).toList();
        System.out.println("Enter price increase: eg: 10% -1.1  20% - 1.2...");
        BigDecimal increase = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
        ingredientService.updatePriceOfWith(names,increase);
    }

    private void runTask10() {
        ingredientService.updatePrice();
        System.out.println("SUCCESS");

    }

    private void runTask9() {
        System.out.println("Enter ingredient name:");
        String name = scanner.nextLine();
        ingredientService.deleteAllByName(name);
        System.out.println("SUCCESS");
    }

    private void runTask8() {
        System.out.println("Enter ingredients count:");
        Long ingredientsCount = Long.parseLong(scanner.nextLine());
        this.shampooServices.findAllByShampooIngredientsCountLessThan(ingredientsCount).forEach(System.out::println);
    }

    private void runTask7() {
        System.out.println("Enter the ingredients:");
        //Berry Mineral-Collagen
        List<String> ingredientsNames = Arrays.stream(scanner.nextLine().split(" ")).toList();
        shampooServices.findAllByIngredientsNames(ingredientsNames).forEach(System.out::println);

    }

    private void runTask6() {
        System.out.println("Enter the price:");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
        System.out.println(shampooServices.countAllByPriceIsLessThan(price));
    }

    private void runTask5() {
        System.out.println("Enter the names:");
        // Lavender Herbs Apple
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).toList();
        ingredientService.findAllByNameIsInOrderByPrice(names).forEach(System.out::println);
    }

    private void runTask4() {
        System.out.println("Enter the letter:");
        String letter = scanner.nextLine();
        ingredientService.findAllByNameIsStartingWith(letter).forEach(System.out::println);

    }

    private void runTask3() {
        System.out.println("Enter Price:");
        BigDecimal priceAbove = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
        shampooServices.findAllByPriceGreaterThanOrderByPriceDesc(priceAbove).forEach(System.out::println);
    }

    private void runTask2() {
        System.out.println("Enter Size:");
        Size size = Size.valueOf(scanner.nextLine());
        System.out.println("Enter label ID:");
        Long labelId = Long.parseLong(scanner.nextLine());
        shampooServices.findAllBySizeOrLabelIdOrderByPrice(size,labelId).forEach(System.out::println);
    }

    private void runTask1() {
        Size mSize = Size.MEDIUM;
        this.shampooServices.findAllBySizeOrderById(mSize)
                .forEach(System.out::println);
    }
}
