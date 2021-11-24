package exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class shoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        while (true){
            String input = scanner.nextLine();
            if (input.equals("Go Shopping!")){
                break;
            }
            String[] token= input.split(" ");
            String command =token[0];
            String product=token[1];
            switch (command){
                case "Urgent":
                    if (!list.contains(product)){
                        list.add(0,product);
                    }
                    break;
                case "Unnecessary":
                    if (list.contains(product)){
                        list.remove(product);
                    }
                    break;
                case "Correct":
                    String newItem = token[2];
                    int index=list.indexOf(product);
                    if (list.contains(product)){
                        list.set(index,newItem);
                    }
                    break;
                case "Rearrange":
                    if (list.contains(product)){
                        list.remove(product);
                        list.add(product);
                    }
            }

        }
        System.out.println(String.join(", ",list));
    }
}
