package Generics.Exercise.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();

        while (!input.equals("END")){
            String[] token = input.split("\\s+");
            String command = token[0];

            switch (command){
                case "Add":
                    customList.add(token[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(token[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(token[1]));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(token[1]);
                    int index2 = Integer.parseInt(token[2]);
                    customList.swap(index1,index2);
                    break;
                case "Greater":
                    System.out.println(customList.greater(token[1]));
                    break;
                case "Max":
                    System.out.println(customList.max());
                    break;
                case "Min":
                    System.out.println(customList.min());
                    break;
                case "Print":
                    System.out.println(customList);
                    break;
                case "Sort":
                    customList.sort();
                    break;
                default:
                    break;
            }

            input= scanner.nextLine();
        }
    }
}
