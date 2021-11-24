package l9regularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p1matchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String names = scanner.nextLine();

        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(names);

        while (matcher.find()){
            System.out.print(matcher.group() + " ");
        }
    }
}
