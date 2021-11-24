package finalExams.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p2mirrorWords {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("([@|#])(?<first>[a-zA-Z]{3,})(\\1)(\\1)(?<second>[a-zA-Z]{3,})(\\1)");
        Matcher matcher = pattern.matcher(text);
        List<String> list = new ArrayList<>();
        int counter= 0;

        while (matcher.find()){
            String first = matcher.group("first");
            String secondRaw = matcher.group("second");
            StringBuilder sb = new StringBuilder(matcher.group("second")).reverse();
            String second = sb.toString();
            counter++;

            if (first.equals(second)){
                list.add(first + " <=> " + secondRaw);
            }
        }
        if (counter>0){
            System.out.printf("%d word pairs found!\n",counter);
            if (list.size()>0){
                System.out.println("The mirror words are:");
                System.out.println(String.join(", " , list));
            }
            else {
                System.out.println("No mirror words!");
            }
        }
        else {
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
        }


    }
}
