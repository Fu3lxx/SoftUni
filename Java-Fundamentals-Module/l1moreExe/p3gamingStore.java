package l1moreExe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p3gamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = Double.parseDouble(scanner.nextLine());
        double totalSpend = 0;
        Map<String , Double> map = new HashMap<>();

        map.put("OutFall 4",39.99);
        map.put("CS: OG",15.99);
        map.put("Zplinter Zell",19.99);
        map.put("Honored 2", 59.99);
        map.put("RoverWatch", 29.99);
        map.put("RoverWatch Origins Edition",39.99);

        String input = scanner.nextLine();
        while (!input.equals("Game Time")){
            if (map.containsKey(input)){
                double price = map.get(input);
                if (balance>=price){
                    System.out.printf("Bought %s\n",input);
                    balance -= price;
                    totalSpend += price;
                    if (balance == 0){
                        System.out.println("Out of mo-ney!");
                        return;
                    }
                }else {
                    System.out.println("Too Expensive");
                }
            }else {
                System.out.println("Not Found");
            }


            input= scanner.nextLine();
        }
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f",totalSpend,balance);
    }
}
