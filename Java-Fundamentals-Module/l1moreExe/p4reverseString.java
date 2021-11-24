package l1moreExe;

import java.util.Scanner;

public class p4reverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());
        System.out.println(sb.reverse());

    }
}
