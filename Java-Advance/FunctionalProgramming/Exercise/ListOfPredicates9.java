package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersRange = Integer.parseInt(scanner.nextLine());

        Set<Integer> divisible = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toSet());

        Predicate<Integer> isDivisible = num -> {
            for (var number: divisible){
                if (num % number != 0){
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= numbersRange ; i++) {
            if (isDivisible.test(i)){
                System.out.print(i + " ");
            }
        }
    }
}
