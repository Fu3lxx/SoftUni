package l1lLabBasicSyntaxConditionStatementsAndLoops;

import java.util.Scanner;

public class p2Passed {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double grade=Double.parseDouble(scanner.nextLine());
        if (grade>=3.00){
            System.out.println("Passed!");
        }
        else {
            System.out.println("Failed!");
        }
    }
}
