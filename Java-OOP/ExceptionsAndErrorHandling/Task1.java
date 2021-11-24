package ExceptionsAndErrorHandling;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        try {
            double sqrt = findSquareRoot(scanner);
            System.out.println(sqrt);
        }
        catch (NumberFormatException exception){
            System.out.println(exception.getMessage());
        }
        finally {
            System.out.println("Good bye");
        }
    }

    private static double findSquareRoot(Scanner scanner) {
       String strNumber = scanner.nextLine();
       for (char symbol:strNumber.toCharArray()){
           if (!Character.isDigit(symbol)){
               throw new NumberFormatException("Invalid Number");
           }
       }
       int number = Integer.parseInt(strNumber);

        return Math.sqrt(number);
    }
}
