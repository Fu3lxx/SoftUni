package l8textProcessing;

import java.util.Scanner;

public class p2repeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] words = scanner.nextLine().split(" ");

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            for (int j = 0; j < currentWord.length(); j++) {
                System.out.print(currentWord);
            }
        }
    }
}
