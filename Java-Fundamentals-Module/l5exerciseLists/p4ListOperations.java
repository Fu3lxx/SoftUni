package l5exerciseLists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p4ListOperations {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        List <Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input= scanner.nextLine();
        while (!input.equals("End")){
            String[] action = input.split(" ");
            if (action[0].equals("Add")){
                int num=Integer.parseInt(action[1]);
                list.add(num);
            }
            else if (action[0].equals("Remove")){
                int num= Integer.parseInt(action[1]);
                if (num>list.size() || num<0){
                    System.out.println("Invalid index");
                }
                else {
                    list.remove(num);
                }

            }
            else if (action[0].equals("Insert")){
                int num= Integer.parseInt(action[1]);
                int index=Integer.parseInt(action[2]);
                if (index>list.size()||index<0){
                    System.out.println("Invalid index");
                }
                else {
                    list.add(index,num);
                }
            }
            else if (action[0].equals("Shift")){
                int times=Integer.parseInt(action[2]);
                if (action[1].equals("right")){
                    for (int i = 0; i <times ; i++) {
                        list.add(0,list.get(list.size()-1));
                        list.remove(list.size()-1);
                    }
                }
                else if (action[1].equals("left")){
                    for (int i = 0; i <times ; i++) {
                        list.add(list.get(0));
                        list.remove(0);
                    }
                }
            }
            input= scanner.nextLine();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
