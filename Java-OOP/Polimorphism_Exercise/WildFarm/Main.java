package Polimorphism_Exercise.WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();

        while (!line.equals("End")) {
            String [] animalLine = line.split("\\s+");
            String[] foodLine = scanner.nextLine().split("\\s+");

            Animal animal = createAnimal(animalLine);
            animals.add(animal);
            Food food = createFood(foodLine);
            animal.makeSound();

            try {
                animal.eatFood(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            line = scanner.nextLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static Food createFood(String[] foodLine) {
        int quantity = Integer.parseInt(foodLine[1]);

        return foodLine[0].equals("Polimorphism_Exercise.WildFarm.Meat") ? new Meat(quantity) : new Vegetable(quantity);
    }

    private static Animal createAnimal(String[] animalLine) {
        switch (animalLine[0]) {
            case "Polimorphism_Exercise.WildFarm.Cat":
                return new Cat(animalLine[1], "Polimorphism_Exercise.WildFarm.Cat", Double.parseDouble(animalLine[2]), animalLine[3], animalLine[4]);
            case "Polimorphism_Exercise.WildFarm.Tiger":
                return new Tiger(animalLine[1], "Polimorphism_Exercise.WildFarm.Tiger", Double.parseDouble(animalLine[2]), animalLine[3]);
            case "Polimorphism_Exercise.WildFarm.Mouse":
                return new Mouse(animalLine[1], "Polimorphism_Exercise.WildFarm.Mouse", Double.parseDouble(animalLine[2]), animalLine[3]);
            case "Polimorphism_Exercise.WildFarm.Zebra":
                return new Zebra(animalLine[1], "Polimorphism_Exercise.WildFarm.Zebra", Double.parseDouble(animalLine[2]), animalLine[3]);
            default:
                throw new IllegalStateException("Unknown animal");
        }
    }
}
