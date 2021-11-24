package finalExamPartTwo;

import java.util.Scanner;

public class p1worldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Travel")){
            String [] token = input.split(":");
            String command = token[0];

            switch (command){
                case "Add Stop":
                    int index = Integer.parseInt(token[1]);
                    String insert = token[2];
                    if (index < text.length() && index >= 0){
                        text.insert(index,insert);
                        System.out.println(text);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(token[1]);
                    int endIndex = Integer.parseInt(token[2]);
                    if (startIndex >= 0 && startIndex < text.length() && endIndex >= 0 && endIndex < text.length()){
                        text.replace(startIndex,endIndex+1,"");
                    }
                    System.out.println(text);
                    break;
                case "Switch":
                    String temp = text.toString();
                    String oldString = token[1];
                    String newString = token[2];

                    if (temp.contains(oldString)){
                        temp = temp.replace(oldString,newString);
                        text.setLength(0);
                        text.append(temp);
                    }
                    System.out.println(text);
                    break;
            }

            input= scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s",text);
    }
}
