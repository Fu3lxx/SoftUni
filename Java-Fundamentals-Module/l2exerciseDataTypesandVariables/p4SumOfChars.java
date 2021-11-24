package l2exerciseDataTypesandVariables;

import java.util.Scanner;

public class p4SumOfChars {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n =Integer.parseInt(scanner.nextLine());
        int sum=0;

        for (int times = 0; times <n; times++) {
            char symbol=scanner.nextLine().charAt(0);
            sum+=(int) symbol;


        }
        System.out.println("The sum equals: " + sum);
    }
}
