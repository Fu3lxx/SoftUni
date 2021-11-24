package l4excercisesMethods;

import java.util.Scanner;

public class p4PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean isValid= true;

        if (!charactersLength(input)){
            System.out.println("Password must be between 6 and 10 characters");
            isValid=false;
        }
        if (!symbolsCheck(input)){
            System.out.println("Password must consist only of letters and digits");
            isValid=false;
        }
        if (!checkForTwoDigits(input)){
            isValid=false;
            System.out.println("Password must have at least 2 digits");
        }
        if (isValid){
            System.out.println("Password is valid");
        }
    }
    public static boolean charactersLength(String input) {
        if (input.length() >= 6 && input.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean symbolsCheck(String input) {
        boolean tick = true;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 65 && input.charAt(i) <= 90 || input.charAt(i) >= 97 && input.charAt(i) <= 122||
                    input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                tick = true;
            } else {
                tick = false;
                break;
            }
        }
        return tick;
    }
    public static boolean checkForTwoDigits (String input){
        int digitCounter=0;

        for (int i = 0; i <input.length() ; i++) {
            if (input.charAt(i) >=48 && input.charAt(i)<=57){
                digitCounter++;
            }
        }
        return digitCounter >= 2;
    }
}
