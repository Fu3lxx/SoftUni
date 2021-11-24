package l9moreExcercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class p1winningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tickets = Arrays.stream(scanner.nextLine().split("\\s*,\\s+")).collect(Collectors.toList());

        for (int i = 0; i <tickets.size() ; i++) {
            String current = tickets.get(i);

            if (current.length()==20){
                String s1a = current.substring(0, (current.length()/2));
                String s1b = current.substring((current.length()/2));

                String regex6 = "[@#$^]{6}";
                String regex7 = "[@#$^]{7}";
                String regex8 = "[@#$^]{8}";
                String regex9 = "[@#$^]{9}";
                String regex10 = "[@#$^]{10}";

                Pattern pattern6 = Pattern.compile(regex6);
                Matcher matcher6 = pattern6.matcher(s1a);
                Matcher matcher62 = pattern6.matcher(s1b);

                Pattern pattern7 = Pattern.compile(regex7);
                Matcher matcher7 = pattern7.matcher(s1a);
                Matcher matcher72 = pattern7.matcher(s1b);

                Pattern pattern8 = Pattern.compile(regex8);
                Matcher matcher8 = pattern8.matcher(s1a);
                Matcher matcher82 = pattern8.matcher(s1b);

                Pattern pattern9 = Pattern.compile(regex9);
                Matcher matcher9 = pattern9.matcher(s1a);
                Matcher matcher92 = pattern9.matcher(s1b);

                Pattern pattern10 = Pattern.compile(regex10);
                Matcher matcher10 = pattern10.matcher(s1a);
                Matcher matcher102 = pattern10.matcher(s1b);

                if (matcher10.find() && matcher102.find()){
                    char matchedElement = matcher10.group().charAt(0);
                    System.out.printf("ticket \"%s\" - 10%c Jackpot!\n",current,matchedElement);
                }
                else if (matcher9.find() && matcher92.find()){
                    char matchedElement = matcher9.group().charAt(0);
                    System.out.printf("ticket \"%s\" - 9%c\n",current,matchedElement);
                }
                else if (matcher8.find() && matcher82.find()){
                    char matchedElement = matcher8.group().charAt(0);
                    System.out.printf("ticket \"%s\" - 8%c\n",current,matchedElement);
                }
                else if (matcher7.find() && matcher72.find()){
                    char matchedElement = matcher7.group().charAt(0);
                    System.out.printf("ticket \"%s\" - 7%c\n",current,matchedElement);
                }
                else if (matcher6.find()&&matcher62.find()){
                    char matchedElement = matcher6.group().charAt(0);

                    System.out.printf("ticket \"%s\" - 6%c\n",current,matchedElement);
                }
                else {
                    System.out.printf("ticket \"%s\" - no match\n",current);
                }
            }else {
                System.out.println("invalid ticket");
            }
        }
    }
}
