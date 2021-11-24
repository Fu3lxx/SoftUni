package SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MinerTask6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")){
            int resource = Integer.parseInt(scanner.nextLine());
            if (map.containsKey(input)){
                map.put(input,resource+map.get(input));
            }
            else {
                map.put(input,resource);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String,Integer> entry: map.entrySet()){
            System.out.printf("%s -> %d\n",entry.getKey(),entry.getValue());
        }
    }
}
