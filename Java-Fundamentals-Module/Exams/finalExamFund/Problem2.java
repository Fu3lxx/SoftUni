package finalExamFund;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            Pattern pattern = Pattern.compile("(.+)\\>(?<first>\\d{3})\\|(?<second>[a-z]{3})\\|(?<third>[A-Z]{3})\\|(?<fourth>[^\\<\\>]{3})\\<\\1$");
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()){
                String first = matcher.group("first");
                String second = matcher.group("second");
                String third = matcher.group("third");
                String fourth = matcher.group("fourth");
                System.out.printf("Password: %s%s%s%s\n",first,second,third,fourth);
            }
            else {
                System.out.println("Try another password!");
            }
        }
    }
}
