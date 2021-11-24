package l5labLists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p4ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List <Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")){
            String[] token = input.split(" ");

            switch (token[0]){
                case "Add":
                    list.add(Integer.parseInt(token[1]));
                    break;
                case "Remove":
                    list.remove(Integer.valueOf(Integer.parseInt(token[1])));
                    break;
                case "RemoveAt":
                    list.remove((Integer.parseInt(token[1])));
                    break;
                case "Insert":
                    int number = Integer.parseInt(token[1]);
                    int index = Integer.parseInt(token[2]);
                    list.add(index,number);
                    break;
            }
            input= scanner.nextLine();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");

        }
    }
}
