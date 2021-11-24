package ExceptionsAndErrorHandling;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Task2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){
            String start = scanner.nextLine();
            String end = scanner.nextLine();

            try {
                printNumberInRange(start,end);
                break;
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }

        }
    }

    private static void printNumberInRange(String start, String end) {
        int startNum;
        int endNum;
        try {
            startNum = Integer.parseInt(start);
            endNum = Integer.parseInt(end);

        }catch (NumberFormatException exception){
            throw new IllegalArgumentException("Invalid input please enter new range.",exception);
        }
        if (!(1 < startNum && startNum < endNum && endNum < 100)){
            throw new IllegalArgumentException("Invalid input please enter new range.");
        }
        IntStream.rangeClosed(startNum,endNum).forEach(System.out::println);
    }
}
