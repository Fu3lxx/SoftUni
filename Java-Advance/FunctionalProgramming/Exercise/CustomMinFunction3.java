package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;

public class CustomMinFunction3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream
                (scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[],Integer> minNum = x-> Arrays.stream(x).min().orElse(0);

        System.out.println(minNum.apply(numbers));
    }
}
