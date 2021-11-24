package l8textProcessing;

import java.util.Scanner;

public class p5digitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder allNum = new StringBuilder();
        StringBuilder allLet = new StringBuilder();
        StringBuilder symbols = new StringBuilder();

        String  text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char cur =text.charAt(i);
            if (Character.isDigit(cur)){
                allNum.append(cur);
            }
            else if (Character.isAlphabetic(cur)){
                allLet.append(cur);
            }
            else {
                symbols.append(cur);
            }
        }
        System.out.println(allNum);
        System.out.println(allLet);
        System.out.println(symbols);
    }
}
