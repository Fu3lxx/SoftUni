package l7associativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p2aMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String,Integer> resources = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("stop")){
            int amount = Integer.parseInt(scanner.nextLine());
            if (!resources.containsKey(input)){
                resources.put(input,amount);
            }else {
                int current = resources.get(input);
                resources.put(input,current+amount);
            }


            input= scanner.nextLine();
        }
        for (var entry : resources.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());

        }
    }
}
