package l7associativeArraysExercise;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p1countCharsInaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("");
        Map<String,Integer> counter = new LinkedHashMap<>();

        for (String entry : text){
            if (entry.equals(" ")){
                continue;
            }
            if (!counter.containsKey(entry)){
                counter.put(entry,1);
            }else {
                counter.put(entry,counter.get(entry) + 1);
            }
        }

        for (var entry :counter.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
