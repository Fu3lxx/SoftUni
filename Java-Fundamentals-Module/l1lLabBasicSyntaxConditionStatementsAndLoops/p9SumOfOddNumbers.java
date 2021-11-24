package l1lLabBasicSyntaxConditionStatementsAndLoops;

import java.util.Scanner;

public class p9SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int num =Integer.parseInt(scanner.nextLine());
        int counter=0;
        int sum=0;
        for (int i = 1; i <=num ; i++) {

            System.out.println(i*2-1);
            sum+=i*2-1;

        }
        System.out.printf("Sum: %d",sum);

        }
    }

