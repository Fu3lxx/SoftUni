package l9regularExpressionsExcercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p3softUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double finalTotal =0;

        while (!input.equals("end of shift")){
            String regex = "%(?<name>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>\\d+.*[0-9]*)\\$$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double total = count*price;
                finalTotal+=total;

                System.out.printf("%s: %s - %.2f\n",name,product,total);
            }



            input= scanner.nextLine();
        }
        System.out.printf("Total income: %.2f",finalTotal);
    }
}
