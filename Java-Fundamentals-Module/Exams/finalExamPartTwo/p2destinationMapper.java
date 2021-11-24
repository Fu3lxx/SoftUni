package finalExamPartTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p2destinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        List<String> list = new ArrayList<>();
        int points = 0;

        Pattern pattern = Pattern.compile("(=|\\/)(?<place>[A-Z][A-Za-z]{2,})(\\1)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            list.add(matcher.group("place"));
            points += matcher.group("place").length();
        }

        System.out.println("Destinations: " + String.join(", " , list));
        System.out.println("Travel Points: " + points);
    }
}
