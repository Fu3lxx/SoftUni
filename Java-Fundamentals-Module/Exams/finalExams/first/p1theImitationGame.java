package finalExams.first;

import java.util.Scanner;

public class p1theImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Decode")){
            String [] token = input.split("\\|");
            String command = token[0];

            switch (command){
                case "Move":
                    int numOfLetters = Integer.parseInt(token[1]);
                    String firstLetters = sb.substring(0,numOfLetters);
                    sb.delete(0,numOfLetters);
                    sb.append(firstLetters);
                    break;

                case "Insert":
                    int index = Integer.parseInt(token[1]);
                    String value = token[2];
                    sb.insert(index,value);
                    break;

                case "ChangeAll":
                    String target = token[1];
                    String replacement = token[2];
                    String temp = sb.toString().replace(target,replacement);
                    sb.setLength(0);
                    sb.append(temp);
                    break;
            }

            input= scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s",sb);

    }
}
