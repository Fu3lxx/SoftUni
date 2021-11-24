package FunctionalProgramming.Lab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortEvenNumbers1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(", "))
                .mapToInt(Integer::parseInt)
                .filter(value -> value % 2 ==0)
                .toArray();

        Function<IntStream,String> formatNumbers = str -> str
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        String evenNumbers = formatNumbers.apply(Arrays.stream(numbers));

        System.out.println(evenNumbers);
        //Arrays.sort(numbers);

        String printSorted = formatNumbers.apply(Arrays.stream(numbers).sorted());
        System.out.println(printSorted);
    }

}
