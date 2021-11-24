package FunctionalProgramming.Lab;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvenOrOdds6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String []data = scanner.nextLine().split(" ");

        int lowerBound = Integer.parseInt(data[0]);
        int upperBound = Integer.parseInt(data[1]);

        String oddOrEven = scanner.nextLine();
        Predicate<Integer> filter = getFilter(oddOrEven);
        Consumer<Integer> printer = x -> System.out.print(x + " ");


        IntStream.rangeClosed(lowerBound,upperBound)
                .boxed()
                .filter(filter)
                .forEach(printer);





    }
    public static Predicate<Integer> getFilter(String oddOrEven){
        if (oddOrEven.equals("even")){
            return x -> x % 2 !=0;
        }
        else {
            return x -> x % 2 == 0;
        }
    }

}
