package l8textProcessing;

import java.util.Scanner;

public class p3substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wordToRemove = scanner.nextLine();
        //StringBuilder text = new StringBuilder(scanner.nextLine());
        String text = scanner.nextLine();

        while (text.contains(wordToRemove)){
            text = text.replace(wordToRemove,"");
        }
        System.out.println(text);
    }
}
