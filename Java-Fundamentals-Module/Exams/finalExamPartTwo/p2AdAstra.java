package finalExamPartTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p2AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        List<String> list = new ArrayList<>();

        Pattern pattern = Pattern.compile("([\\||#])(?<name>[a-zA-Z]+ *[A-Za-z]*)(\\1)(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})(\\1)(?<calories>[0-9]+)(\\1)");
        Matcher matcher = pattern.matcher(text);
        int totalCalories = 0;

        while (matcher.find()){
            String name = matcher.group("name");
            String date = matcher.group("date");
            String nutrition = matcher.group("calories");

            totalCalories += Integer.parseInt(nutrition);

            list.add("Item: " + name + ", Best before: " + date + ", Nutrition: " + nutrition);
        }
        System.out.printf("You have food to last you for: %d days!\n",totalCalories / 2000);
        list.forEach(System.out::println);
    }
}
