package l4excercisesMethods;

import java.util.Scanner;

public class p7NxnMatrix {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        int input= Integer.parseInt(scanner.nextLine());
        matrixPrinter(input);
    }
    public static void matrixPrinter (int input){
        for (int i = 1; i <=input ; i++) {
            for (int j = 1; j <=input ; j++) {
                System.out.print(input + " ");
            }
            System.out.println();
        }
    }
}
