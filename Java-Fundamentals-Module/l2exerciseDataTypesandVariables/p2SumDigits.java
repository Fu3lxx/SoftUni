package l2exerciseDataTypesandVariables;

import java.util.Scanner;

public class p2SumDigits {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int num=Integer.parseInt(scanner.nextLine());
        int sum=0;

        while (num!=0){
            int currentDigit=num%10;
            sum+=currentDigit;
            num/=10;
        }
        System.out.println(sum);
    }
}
