package l8textProcessing;

import java.util.Scanner;

public class p1reverseStrings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("end")){
            StringBuilder sb = new StringBuilder(input);
            StringBuilder reverse = sb.reverse();
            System.out.println(input + " = " + reverse);
            input= scanner.nextLine();
        }
    }
}
