package finalExams.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p2adAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        List <String> list = new ArrayList<>();
        int totalCalories = 0;

        Pattern pattern = Pattern.compile("([|#])(?<name>[A-Za-z]+ *[A-Za-z]*)(\\1)(?<date>[0-9]{2}/[0-9]{2}/[0-9]{2})(\\1)(?<calories>[0-9]+)(\\1)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            String name = matcher.group("name");
            String date = matcher.group("date");
            String calories = matcher.group("calories");
            totalCalories+=Integer.parseInt(calories);

            StringBuilder sb = new StringBuilder("Item: " + name + ", Best before: " + date + ", Nutrition: " + calories);
            list.add(sb.toString());
        }
        System.out.println("You have food to last you for: " + totalCalories/2000 + " days!");
        list.forEach(System.out::println);
    }
}
