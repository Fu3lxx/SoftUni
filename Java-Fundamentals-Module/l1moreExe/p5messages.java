package l1moreExe;

import java.util.Scanner;

public class p5messages {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            String digits = scanner.nextLine();
            int mainDigit = Integer.parseInt( digits ) % 10;

            if (mainDigit == 0){
                System.out.print(" ");
                continue;
            }
            int numLength = digits.length();
            int offset = 0;

            if (mainDigit == 8 || mainDigit == 9 ){
                offset = (mainDigit - 2) * 3 + 1;
            }else {
                offset = (mainDigit - 2) * 3;
            }
            int letterIndex = (offset + numLength - 1) + 97;
            System.out.printf("%c",letterIndex);
        }
    }
}
