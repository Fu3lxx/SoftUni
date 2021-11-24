package l2exerciseDataTypesandVariables;

import java.util.Scanner;

public class p3Elevator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int elCapacity=Integer.parseInt(scanner.nextLine());
        int people=Integer.parseInt(scanner.nextLine());

        double courses= Math.ceil(elCapacity*1.0/people);
        System.out.printf("%.0f",courses);
    }
}
