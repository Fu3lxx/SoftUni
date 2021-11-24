package l4excercisesMethods;

import java.util.Scanner;

public class p8FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fist =Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        System.out.printf("%.2f", factorial(fist) / factorial(second));

    }
    public static double factorial (int digit){
        double fact= 1;
        for (int i = 1; i <=digit ; i++) {
            fact*=i;
        }
        return fact;
    }
}
