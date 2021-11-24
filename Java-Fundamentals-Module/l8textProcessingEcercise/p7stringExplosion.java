package l8textProcessingEcercise;

import java.util.Scanner;

public class p7stringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder(input);
        int power =0;

        for (int i = 0; i <text.length() ; i++) {

            if (text.charAt(i) != '>' && power>0){
                text.deleteCharAt(i);
                power--;
                i--;
            }

            else if (text.charAt(i) == '>'){
                power+=Integer.parseInt(String.valueOf(text.charAt(i+1)));
            }

        }
        System.out.println(text);
    }
}
