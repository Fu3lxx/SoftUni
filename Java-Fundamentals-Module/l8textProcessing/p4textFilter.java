package l8textProcessing;

import java.util.Scanner;

public class p4textFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] wordToRemove = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i < wordToRemove.length; i++) {
            StringBuilder word = new StringBuilder();
            for (int j = 0; j <wordToRemove[i].length(); j++) {
                word.append("*");
            }
            while (text.contains(wordToRemove[i])){
                text=text.replace(wordToRemove[i],word);
            }
        }
        System.out.println(text);
    }
}
