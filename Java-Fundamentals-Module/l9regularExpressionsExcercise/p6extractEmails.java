package l9regularExpressionsExcercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p6extractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List <String> emails = new ArrayList<>();

        String regex = "\\b[a-zA-Z0-9]+[.\\-_]*[A-Za-z0-9]*@[a-zA-Z]+.[a-zA-Z]+[.?[a-zA-Z]]*\\b";
        Pattern patter = Pattern.compile(regex);
        Matcher matcher = patter.matcher(input);

        while (matcher.find()){
            emails.add(matcher.group());
        }

        emails.forEach(System.out::println);

    }
}
