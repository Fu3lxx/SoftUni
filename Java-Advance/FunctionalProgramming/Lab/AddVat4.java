package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AddVat4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String,Double> mapWithVAT = str -> Double.parseDouble(str) * 1.2;

        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(", "))
                .map(mapWithVAT)
                .forEach(e -> System.out.printf("%.2f\n",e));
    }
}
