package finalExamPartTwo;

import java.util.Scanner;

public class p1TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder code = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Decode")){
            String [] token = input.split("\\|");
            String command = token[0];

            switch (command){
                case "Move":
                    int nLetters = Integer.parseInt(token[1]);
                    StringBuilder sb = new StringBuilder(code.substring(0,nLetters));
                    code.replace(0,nLetters,"");
                    code.append(sb);
                    break;

                case "Insert":
                    int indexInsert = Integer.parseInt(token[1]);
                    String toInsert = token[2];
                    code.insert(indexInsert,toInsert);
                    break;

                case "ChangeAll":
                    String target = token[1];
                    String replacement = token[2];

                    String temp = code.toString();
                    temp = temp.replace(target,replacement);
                    code.setLength(0);
                    code.append(temp);
                    break;
            }
            input= scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s",code);
    }
}
