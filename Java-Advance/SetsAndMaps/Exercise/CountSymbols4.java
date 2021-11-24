package SetsAndMaps.Exercise;

import java.util.*;
import java.util.stream.Stream;

public class CountSymbols4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<Character,Integer> map = new TreeMap<>();

        for (int i = 0; i <input.length() ; i++) {
            char current = input.charAt(i);
            if (!map.containsKey(current)){
                map.put(current,1);
            }
            else {
                map.put(current,map.get(current)+1);
            }

        }

        map.entrySet().forEach(e -> System.out.printf("%c: %d time/s\n",e.getKey(),e.getValue()));
    }
}
