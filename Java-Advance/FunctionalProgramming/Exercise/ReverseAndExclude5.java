package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(numbers);
        int divisible = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> filter = num -> num % divisible != 0;
        Consumer <Integer> printer = num -> System.out.print(num + " ");


        numbers.stream().filter(filter).forEach(printer);
    }
}
