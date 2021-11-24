package finalExamPartTwo;

import java.util.Scanner;

public class p1activationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder key = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Generate")){
            String [] token = input.split(">>>");
            String command = token[0];

            switch (command){
                case "Contains":
                    String substring = token[1];
                    if (key.toString().contains(substring)){
                        System.out.printf("%s contains %s\n",key,substring);
                    }else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upOrLow = token[1];
                    int start = Integer.parseInt(token[2]);
                    int end = Integer.parseInt(token[3]);

                    if (upOrLow.equals("Upper")){
                        for (int i = start; i <end ; i++) {
                            key.setCharAt(i,Character.toUpperCase(key.charAt(i)));
                        }
                    }else {
                        for (int i = start; i <end ; i++) {
                            key.setCharAt(i,Character.toLowerCase(key.charAt(i)));
                        }
                    }
                    System.out.println(key);
                    break;
                case "Slice":
                    int startIndex = Integer.parseInt(token[1]);
                    int endIndex = Integer.parseInt(token[2]);
                    key.replace(startIndex,endIndex,"");
                    System.out.println(key);
                    break;
            }

            input= scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s",key);
    }
}
