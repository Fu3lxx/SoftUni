package FunctionalProgramming.Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] names = scanner.nextLine().split("\\s+");

        Consumer<String[]> printer = x -> {
            for (var name:x){
                System.out.println(name);
            }
        };

        printer.accept(names);

    }
}
