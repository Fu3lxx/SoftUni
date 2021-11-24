package finalExamPartTwo;

import java.util.Scanner;

public class p1passwordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder rawCode = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Done")){
            String [] token = input.split(" ");
            String command = token[0];

            switch (command){
                case "TakeOdd":
                    StringBuilder odd = new StringBuilder();
                    for (int i = 1; i <rawCode.length() ; i+=2) {
                        odd.append(rawCode.charAt(i));
                    }
                    rawCode.setLength(0);
                    rawCode.append(odd);
                    System.out.println(rawCode);
                    break;
                case "Cut":
                    int index = Integer.parseInt(token[1]);
                    int length = Integer.parseInt(token[2]);
                    StringBuilder wordToRemove = new StringBuilder();
                    for (int i = index; i < index + length ; i++) {
                        wordToRemove.append(rawCode.charAt(i));
                    }
                    String code = rawCode.toString();
                    code=code.replaceFirst(wordToRemove.toString(),"");
                    rawCode.setLength(0);
                    rawCode.append(code);
                    System.out.println(rawCode);
                    break;
                case "Substitute":
                    String target = token[1];
                    String replacement = token[2];
                    if (rawCode.toString().contains(target)){
                        String code1 = rawCode.toString();
                        code1=code1.replace(target,replacement);
                        rawCode.setLength(0);
                        rawCode.append(code1);
                        System.out.println(rawCode);
                    }else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            input= scanner.nextLine();
        }
        System.out.printf("Your password is: %s",rawCode);
    }
}
