package exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        while (true){
            String input = scanner.nextLine();
            if (input.equals("Craft!")){
                break;
            }
            String[] token = input.split(" - ");
            String command= token[0];
            String item= token[1];

            if (command.equals("Collect")){
                if (!items.contains(item)){
                    items.add(item);
                }
            }
            else if (command.equals("Drop")){
                if (items.contains(item)){
                    items.remove(item);
                }
            }
            else if (command.equals("Combine Items")){
                String [] itemsToCombine = item.split(":");
                String oldItem =itemsToCombine[0];
                String newItem= itemsToCombine[1];
                int indexOfOldItem = items.indexOf(oldItem);
                if (items.contains(oldItem)){

                    items.add(indexOfOldItem+1,newItem);
                }
            }
            else if (command.equals("Renew")){
                if (items.contains(item)){
                    int indexOfRenewItem = items.indexOf(item);
                    items.remove(indexOfRenewItem);
                    items.add(item);
                }
            }
        }
        System.out.println(String.join(", ",items));
    }
}
