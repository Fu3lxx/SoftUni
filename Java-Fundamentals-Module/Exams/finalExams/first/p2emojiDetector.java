package finalExams.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p2emojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        long trashHold= 1;

        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitMatcher = digitPattern.matcher(input);
        while (digitMatcher.find()){
            int number = Integer.parseInt(digitMatcher.group());
            trashHold*=number;
        }

        Pattern emojiPattern = Pattern.compile("([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})(\\1)");
        Matcher emojiMatcher = emojiPattern.matcher(input);
        int emojiCounter =0;
        List<String> list = new ArrayList<>();

        while (emojiMatcher.find()){
            String currentEmoji = emojiMatcher.group("emoji");

            emojiCounter++;
            int emojiPoints = 0;

            for (int i = 0; i <currentEmoji.length() ; i++) {
                emojiPoints+= (char) currentEmoji.charAt(i);
            }
            String finalEmoji = emojiMatcher.group(1)+currentEmoji+emojiMatcher.group(1);
            if (emojiPoints> trashHold){
                list.add(finalEmoji);
            }
        }
        System.out.printf("Cool threshold: %d\n%d emojis found in the text. The cool ones are:\n",trashHold,emojiCounter);
        list.forEach(System.out::println);


    }
}
