package finalExams.first;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p2factoryBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i <times ; i++) {
            String input = scanner.nextLine();
            Pattern patternB = Pattern.compile("(@[#]+)([A-Z][a-zA-Z0-9]{4,}[A-Z])@([#]+)");
            Matcher matcherB = patternB.matcher(input);

            if (matcherB.find()){
                StringBuilder code = new StringBuilder();
                Pattern patternN = Pattern.compile("[0-9]");
                Matcher matcherN = patternN.matcher(input);

                while (matcherN.find()){
                    code.append(matcherN.group());
                }
                if (code.length() !=0){
                    System.out.println("Product group: " + code);
                }
                else {
                    System.out.println("Product group: 00");
                }

            }
            else {
                System.out.println("Invalid barcode");
            }
        }


    }
}
