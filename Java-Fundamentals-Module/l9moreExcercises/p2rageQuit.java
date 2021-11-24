package l9moreExcercises;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p2rageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase(Locale.ROOT);

        String regex = "(?<message>[^\\d]+)(?<times>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()){
            String message =matcher.group("message");
            int times = Integer.parseInt(matcher.group("times"));

            for (int i = 0; i <times ; i++) {
                sb.append(message);
            }
        }
        System.out.printf("Unique Symbols used: %d\n",sb.chars().distinct().count());
        System.out.println(sb);


    }
}
