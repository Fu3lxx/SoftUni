package l8textProcessingEcercise;

import java.util.Scanner;

public class p4caesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char [] input = scanner.nextLine().toCharArray();

        for (char i : input){
            char  currentChar = (char) (i + 3);
            System.out.print(currentChar);
        }
    }
}
