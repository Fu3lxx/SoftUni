package l4excercisesMethods;

import java.util.Scanner;

public class p6MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        findMiddleCharacter(input);

    }
    public static void findMiddleCharacter(String input){
        int middle=input.length() / 2;
        if (input.length()%2==0){
            System.out.print(input.charAt(middle-1));
            System.out.print(input.charAt(middle));

        }else {
            System.out.println(input.charAt(middle));
        }
    }
}
