package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountCapitalLetters3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> capitalLetter = str -> Character.isUpperCase(str.charAt(0));
        String [] arr = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .filter(capitalLetter)
                .toArray(String[]::new);

        System.out.println(arr.length);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
