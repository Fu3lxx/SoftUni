package l7associativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class p4orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map <String , Double> price= new LinkedHashMap<>();
        Map <String , Integer> quantity = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("buy")){
            String [] token = input.split(" ");
            if (!price.containsKey(token[0])){
                price.put(token[0],Double.parseDouble(token[1]));
                quantity.put(token[0],Integer.parseInt(token[2]));
            }else {
                price.put(token[0],Double.parseDouble(token[1]));
                int current = quantity.get(token[0]);
                quantity.put(token[0],Integer.parseInt(token[2]) + current );
            }


            input= scanner.nextLine();
        }

        for (var entry : price.entrySet()){
            double totalPrice = entry.getValue() * quantity.get(entry.getKey());

            System.out.printf("%s -> %.2f\n",entry.getKey(),totalPrice);
        }
    }
}
