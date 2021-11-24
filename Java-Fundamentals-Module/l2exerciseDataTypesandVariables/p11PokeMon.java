package l2exerciseDataTypesandVariables;

import java.util.Scanner;

public class p11PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int nextTarget = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        while (power >= nextTarget) {
            if (power==nextTarget){
                power=power/exhaustionFactor;
            }
            if (power > nextTarget) {
                counter++;
                power = power - nextTarget;
            }


        }
        System.out.printf("%d\n%d",power,counter);
    }
}
