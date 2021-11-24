package finalExamPartTwo;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p2fancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            Pattern pattern = Pattern.compile("(?<fullCode>@[#]+(?<name>[A-Z][A-Za-z0-9]{4,}[A-Z])@[#]+)");
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()){
                String name = matcher.group("name");
                Pattern patternDigits = Pattern.compile("[0-9]");
                Matcher matcherDigits = patternDigits.matcher(name);
                StringBuilder digits = new StringBuilder();
                while (matcherDigits.find()){
                    digits.append(matcherDigits.group());
                }
                if (digits.length()>0){
                    System.out.printf("Product group: %s\n",digits);
                }else {
                    System.out.println("Product group: 00");
                }
            }
            else {
                System.out.println("Invalid barcode");
            }

        }



    }
}
