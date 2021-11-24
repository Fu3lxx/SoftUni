package l8textProcessingEcercise;

import java.util.Locale;
import java.util.Scanner;

public class p8lettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        double total = 0;

        for (int i = 0; i < input.length; i++) {
            String code = input[i];
            char firstLetter = code.charAt(0);
            char secondLetter = code.charAt(code.length()-1);
            String number = code.replaceAll("[^0-9.]", "");
            double num = Double.parseDouble(number);
            String a = "a";
            int position =0;


            if (Character.isUpperCase(firstLetter)){
                position= firstLetter-64;
                num = num / position;
            }
            else if (Character.isLowerCase(firstLetter)){
                position= firstLetter - 96;
                num = num * position;
            }

            if (Character.isUpperCase(secondLetter)){
                position= secondLetter-64;
                num= num - position;
            }
            else if (Character.isLowerCase(secondLetter)){
                position= secondLetter - 96;
                num = num + position;
            }
            total+= num;


        }
        System.out.printf("%.2f",total);
    }
}
