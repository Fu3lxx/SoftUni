package finalExamPartTwo;

import java.util.Scanner;

public class p1secretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Reveal")){
            String [] token = input.split(":\\|:");
            String command = token[0];

            switch (command){
                case "InsertSpace":
                    int index = Integer.parseInt(token[1]);
                    text.insert(index," ");
                    System.out.println(text);
                    break;
                case "Reverse":
                    String substring = token[1];
                    if (text.toString().contains(substring)){
                        String str = text.toString();
                        str = str.replaceFirst(substring,"");
                        text.setLength(0);
                        text.append(str);
                        StringBuilder reversed = new StringBuilder(substring);
                        reversed.reverse();
                        text.append(reversed);
                        System.out.println(text);
                    }
                    else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String target = token[1];
                    String replacement = token[2];

                    String str2 = text.toString();
                    str2 = str2.replace(target,replacement);
                    text.setLength(0);
                    text.append(str2);
                    System.out.println(text);
                    break;
            }
            input= scanner.nextLine();
        }
        System.out.println("You have a new text message: " + text );
    }
}
