package l9regularExpressionsExcercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class p2race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map = new LinkedHashMap<>();
        List<String> names = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        names.forEach(name -> map.put(name, 0));

        String input = scanner.nextLine();

        while (!input.equals("end of race")) {
            StringBuilder name = new StringBuilder();
            String regexName = "[A-Za-z]";
            Pattern patternName = Pattern.compile(regexName);
            Matcher matcherName = patternName.matcher(input);
            while (matcherName.find()) {
                name.append(matcherName.group());
            }

            int km = 0;
            String regexNum = "[0-9]";
            Pattern patternNum = Pattern.compile(regexNum);
            Matcher matcherNum = patternNum.matcher(input);
            while (matcherNum.find()) {
                km += Integer.parseInt(matcherNum.group());
            }

            String nameString = name.toString();
            if (map.containsKey(nameString)) {
                if (map.get(nameString) > 0) {
                    map.put(nameString, map.get(nameString) + km);
                } else {
                    map.put(nameString, km);
                }
            }


            input = scanner.nextLine();
        }
        List<String> firstThree =map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println("1st place: " + firstThree.get(0));
        System.out.println("2nd place: " + firstThree.get(1));
        System.out.println("3rd place: " + firstThree.get(2));

    }
}
