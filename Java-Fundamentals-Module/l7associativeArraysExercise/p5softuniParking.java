package l7associativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p5softuniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> register = new LinkedHashMap<>();

        int times = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < times; i++) {
            String [] input = scanner.nextLine().split(" ");
            if (input[0].equals("register")){
                if (!register.containsKey(input[1])){
                    register.put(input[1],input[2] );
                    System.out.println(input[1] +" registered " + input[2] + " successfully");
                }else {
                    System.out.println("ERROR: already registered with plate number " + register.get(input[1]));
                }
            }
            if (input[0].equals("unregister")){
                if (register.containsKey(input[1])){
                    register.remove(input[1]);
                    System.out.println(input[1] + " unregistered successfully");
                }else {
                    System.out.println("ERROR: user " + input[1] + " not found");
                }
            }


        }
        for ( var entry : register.entrySet()){
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
