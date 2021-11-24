package l5labLists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p5ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")){
            String[] command =input.split(" ");

            switch (command[0]){
                case "Contains":
                    if (list.contains(Integer.parseInt(command[1]))){
                        System.out.println("Yes");
                    }else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (command[1].equals("even")){
                        printEven(list);
                        System.out.println();
                        break;
                    }else {
                        printOdd(list);
                        System.out.println();
                    }
                    break;
                case "Get":
                    printSum(list);

                    break;
                case "Filter":
                    int num = Integer.parseInt(command[2]);
                    if (command[1].equals("<")){
                        printLower(list,num);
                        System.out.println();
                    }
                    if (command[1].equals(">")){
                        printHigher(list,num);
                        System.out.println();
                    }
                    if (command[1].equals(">=")){
                        printHigherAndEqual(list,num);
                        System.out.println();
                    }
                    if (command[1].equals("<=")){
                        printLowerAndEqual(list,num);
                        System.out.println();
                    }
                    break;
            }



            input= scanner.nextLine();
        }
    }
    public static void printEven (List<Integer> list){
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i) % 2 == 0){
                System.out.print(list.get(i) + " ");
            }
        }
    }
    public  static void printOdd(List<Integer> list){
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i) % 2 !=0){
                System.out.print(list.get(i)+ " ");
            }
        }
    }
    public static void printSum (List<Integer> list){
        int sum= 0;
        for (int i = 0; i <list.size() ; i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }
    public static void printLower (List<Integer> list , int num){
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i) < num){
                System.out.print(list.get(i) + " ");
            }
        }
    }
    public static void printHigher (List<Integer> list , int num){
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i) > num){
                System.out.print(list.get(i) + " ");
            }
        }
    }
    public static void printHigherAndEqual (List<Integer> list , int num){
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i) >= num){
                System.out.print(list.get(i)+ " ");
            }
        }
    }
    public static void printLowerAndEqual (List<Integer> list , int num){
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i) <= num){
                System.out.print(list.get(i)+ " ");
            }
        }
    }
}
