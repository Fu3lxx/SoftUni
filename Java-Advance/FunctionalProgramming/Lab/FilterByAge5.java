package FunctionalProgramming.Lab;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map <String,Integer> map = new LinkedHashMap<>();

        for (int i = 0; i <n ; i++) {
            String [] info = scanner.nextLine().split(", ");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            map.put(name,age);
        }

        String ageConditional = scanner.nextLine();
        int ageUpOrDown = Integer.parseInt(scanner.nextLine());
        String printConditional = scanner.nextLine();

        Predicate<Map.Entry<String,Integer>> ageFilter =
                getAgeFilter(ageUpOrDown,ageConditional);

        map.entrySet()
                .stream()
                .filter(getAgeFilter(ageUpOrDown,ageConditional))
                .forEach(getFormatter(printConditional));
    }

    private static Predicate<Map.Entry<String, Integer>> getAgeFilter(int ageUpOrDown, String ageConditional) {
        if (ageConditional.equals("older")){
            return e -> e.getValue() >= ageUpOrDown;
        }
        else {
            return e -> e.getValue() <= ageUpOrDown;
        }

    }
    public static Consumer<Map.Entry<String,Integer>> getFormatter(String format) {

            if (format.equals("name")){
               return entry -> System.out.println(entry.getKey());
            }
            else if (format.equals("age")){
                return entry -> System.out.println(entry.getValue());
            }
            return entry -> System.out.println(entry.getKey() + " - " + entry.getValue());
        }

}
