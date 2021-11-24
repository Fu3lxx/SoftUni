package finalExamPartTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p2emojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern patternEmoji = Pattern.compile("(::|\\*\\*)(?<name>[A-Z][a-z]{2,})(\\1)");
        Matcher matcherEmoji = patternEmoji.matcher(text);

        Pattern digitsP = Pattern.compile("[0-9]");
        Matcher digitsM = digitsP.matcher(text);
        int threshold = 1;
        int emojiCounter = 0;
        List <String> list = new ArrayList<>();

        while (digitsM.find()){
            threshold*= Integer.parseInt(digitsM.group());
        }

        while (matcherEmoji.find()){
            String emoji = matcherEmoji.group("name");
            String fullEmoji = matcherEmoji.group(1) + emoji + matcherEmoji.group(1);
            int emojiPoints = 0;
            emojiCounter++;

            for (int i = 0; i < emoji.length(); i++) {
                emojiPoints += emoji.charAt(i);
            }

            if (emojiPoints >= threshold){
                list.add(fullEmoji);
            }
        }
        System.out.printf("Cool threshold: %d\n",threshold);
        System.out.printf("%d emojis found in the text. The cool ones are:\n",emojiCounter);

        list.forEach(e -> System.out.println(e));
    }
}
