package finalExams.first;

import java.util.Locale;
import java.util.Scanner;

public class p1activationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rawCode = scanner.nextLine();
        StringBuilder code = new StringBuilder(rawCode);
        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] command = input.split(">>>");

            if (command[0].equals("Contains")) {
                if (code.toString().contains((command[1]))) {
                    System.out.println(code.toString() + " contains " + command[1]);
                } else {
                    System.out.println("Substring not found!");
                }
            } else if (command[0].equals("Slice")) {
                int startIndex = Integer.parseInt(command[1]);
                int endIndex = Integer.parseInt(command[2]);
                code.replace(startIndex, endIndex, "");
                System.out.println(code.toString());
            } else if (command[0].equals("Flip")) {
                int starIndex = Integer.parseInt(command[2]);
                int endIndex = Integer.parseInt(command[3]);

                if (command[1].equals("Upper")) {
                    for (int i = starIndex; i < endIndex; i++) {
                        code.setCharAt(i, Character.toUpperCase(code.charAt(i)));
                    }
                    System.out.println(code.toString());
                } else {
                    for (int i = starIndex; i < endIndex; i++) {
                        code.setCharAt(i, Character.toLowerCase(code.charAt(i)));
                    }
                    System.out.println(code.toString());
                }


            }
            input = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + code.toString());
    }
}
