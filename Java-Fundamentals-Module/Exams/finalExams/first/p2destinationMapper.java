package finalExams.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p2destinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("([=\\/])(?<name>[A-Z][a-zA-Z]{2,})(\\1)");
        Matcher matcher = pattern.matcher(text);
        int points = 0;

        List<String> list = new ArrayList<>();
        while (matcher.find()){
            String name = matcher.group("name");
            points+= name.length();
            list.add(name);
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", " , list));
        System.out.println("Travel Points: " + points);

    }
}
