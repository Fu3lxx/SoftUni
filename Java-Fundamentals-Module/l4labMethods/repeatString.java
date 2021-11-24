package l4labMethods;

import java.util.Scanner;

public class repeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int times=Integer.parseInt(scanner.nextLine());
        repeater(text,times);
    }

    public static void repeater(String text,int times) {
        for (int i = 1; i <=times ; i++) {
            System.out.print(text);
        }
    }
}
