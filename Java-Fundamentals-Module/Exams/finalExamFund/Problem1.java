package finalExamFund;

import java.util.Locale;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder user = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Sign up")){
            String [] token = input.split(" ");
            String command = token[0];

            switch (command){
                case "Case":
                    String upOrLow = token[1];
                    String temp = user.toString();
                    if (upOrLow.equals("upper")){
                        temp=temp.toUpperCase(Locale.ROOT);
                    }
                    else if (upOrLow.equals("lower")){
                        temp=temp.toLowerCase(Locale.ROOT);
                    }
                    user.setLength(0);
                    user.append(temp);
                    System.out.println(user);
                    break;

                case "Reverse":
                    int startIndex = Integer.parseInt(token[1]);
                    int endIndex = Integer.parseInt(token[2]);

                    if (startIndex >= 0 && startIndex < user.length() && endIndex > 0 && endIndex <= user.length()){
                        StringBuilder sb = new StringBuilder(user.substring(startIndex,endIndex + 1));
                        sb.reverse();
                        System.out.println(sb);
                    }
                    break;

                case "Cut":
                    String toCut = token[1];
                    String cutter = user.toString();
                    if (user.toString().contains(toCut)){
                        cutter=cutter.replace(toCut,"");
                        user.setLength(0);
                        user.append(cutter);
                        System.out.println(user);
                    }
                    else {
                        System.out.printf("The word %s doesn't contain %s.\n",user,toCut);
                    }
                    break;

                case "Replace":
                    String target = token[1];
                    String replacer = user.toString();
                    if (replacer.contains(target)){
                        replacer=replacer.replace(target,"*");
                        user.setLength(0);
                        user.append(replacer);
                    }
                    System.out.println(user);
                    break;

                case "Check":
                    String contains = token[1];
                    if (user.toString().contains(contains)){
                        System.out.println("Valid");
                    }
                    else {
                        System.out.printf("Your username must contain %s.\n",contains);
                    }
                    break;

            }

            input= scanner.nextLine();
        }
    }
}
