package l4excercisesMethods;

import java.util.Locale;
import java.util.Scanner;

public class p2VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        System.out.println(vowelCounter(text));

    }
    public static int vowelCounter (String text){
        text = text.toLowerCase(Locale.ROOT);
        char[] textArr = text.toCharArray();
        int counter = 0;

        for (int i = 0; i < textArr.length; i++) {
            if (text.charAt(i)=='a'||text.charAt(i)=='e'||text.charAt(i)=='i'||text.charAt(i)=='o'||text.charAt(i)=='u'){
                counter++;
            }
        }
        return counter;
    }
}
