package WorkingwithAbstractionLab;

import java.util.Scanner;

public class _1RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= size ; i++) {
            printRow(size,i);
        }
        for (int i = size-1; i >=1 ; i--) {
            printRow(size,i);
        }
    }
    private static void printRow(int size, int count) {
        for (int i = 0; i < size-count; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < count; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
