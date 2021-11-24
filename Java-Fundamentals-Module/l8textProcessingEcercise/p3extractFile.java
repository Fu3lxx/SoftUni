package l8textProcessingEcercise;

import java.util.Scanner;

public class p3extractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\\\");
        String [] info = input[input.length - 1].split("\\.");

        System.out.println("File name: " + info[0]);
        System.out.println("File extension: " + info[1]);
    }
}
