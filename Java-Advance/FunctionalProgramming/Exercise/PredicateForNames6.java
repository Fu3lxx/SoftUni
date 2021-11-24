package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        Predicate<String> filter = name -> name.length() <= length;

        String [] names = scanner.nextLine().split("\\s+");

        Arrays.stream(names).filter(filter).forEach(s -> System.out.println(s));


    }
}
