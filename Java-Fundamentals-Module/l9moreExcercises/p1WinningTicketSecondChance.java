package l9moreExcercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class p1WinningTicketSecondChance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("\\s*,\\s*")).collect(Collectors.toList());


        for (int i = 0; i <list.size() ; i++) {
            String currentCode = list.get(i);

            if (currentCode.length() == 20){
                String left = currentCode.substring(0,10);
                String right = currentCode.substring(10,20);

                Pattern pattern = Pattern.compile("(?<win>[$@#^]{6,})");
                Matcher matcherL = pattern.matcher(left);
                Matcher matcherR = pattern.matcher(right);
                if (matcherR.find() && matcherL.find()){
                    StringBuilder matchR = new StringBuilder(matcherR.group());
                    StringBuilder matchL = new StringBuilder(matcherL.group());
                    int rLength = matchR.length();
                    int lLength = matchL.length();
                    if (matchR.length() > matchL.length()){
                        matchR.setLength(lLength);
                    }
                    else if (matchL.length()>matchR.length()){
                        matchL.setLength(rLength);
                    }

                    if (matchL.toString().equals(matchR.toString())){
                        String winningPart = matchR.toString();
                        char winSymbol = winningPart.charAt(0);
                        if (winningPart.length()==10){
                            System.out.printf("ticket \"%s\" - %d%c Jackpot!\n",currentCode,winningPart.length(),winSymbol);
                        }
                        else {
                            System.out.printf("ticket \"%s\" - %d%c\n",currentCode,winningPart.length(),winSymbol);
                        }
                    }
                    else {
                        System.out.printf("ticket \"%s\" - no match\n",currentCode);
                    }
                }
                else {
                    System.out.printf("ticket \"%s\" - no match\n",currentCode);
                }
            }
            else {
                System.out.println("invalid ticket");
            }
        }

    }
}
