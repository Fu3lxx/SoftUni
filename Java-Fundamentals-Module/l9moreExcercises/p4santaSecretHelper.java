package l9moreExcercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p4santaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decodeNum = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("end")){
            StringBuilder decrypted = new StringBuilder();
            for (int i = 0; i <input.length() ; i++) {
                char current = input.charAt(i) ;
                decrypted.append((char) (current - decodeNum));
            }
            String code = decrypted.toString();
            String regex = "@(?<name>[a-zA-z]+)[^!@\\-:>]+!(?<type>[GN])!";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(code);
            if (matcher.find()){
                String name = matcher.group("name");
                String type = matcher.group("type");
                if (type.equals("G")){
                    System.out.println(name);
                }
            }



            input= scanner.nextLine();
        }
    }
}
