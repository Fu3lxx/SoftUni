package l4excercisesMethods;

import java.util.Scanner;

public class p9PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String input= scanner.nextLine();
        while (!input.equals("END")){

            System.out.println(palindromeFinder(input));
            input= scanner.nextLine();
        }
    }
    public static boolean palindromeFinder (String input){
        int number = Integer.parseInt(input);
        int numberCopy =number;
        int reversed=0;


        while (number!=0){
            int lastDigit=number%10;
            reversed=reversed*10+lastDigit;
            number=number/10;
        }
        if(numberCopy==reversed){
            return true;
        }
        else {
            return false;
        }

    }


}
