package l4excercisesMethods;

import java.util.Scanner;

public class p10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num= Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <=num ; i++) {
            if (isItContainOddDigit(i) && isItDivisibleBy8(i)){
                System.out.println(i);
            }

        }

    }
    public static boolean isItContainOddDigit (int num){
        int number=num;
        boolean haveOddDigit=false;

        while (number!=0){
            int currentDigit=number%10;
            if (currentDigit % 2 == 1){
                haveOddDigit=true;
                break;
            }
            number=number/10;
        }
        if (haveOddDigit){
            return true;
        }else {
            return false;
        }
    }
    public static boolean isItDivisibleBy8 (int num){
        int sum=0;

        while (num!=0){
            int currentDigit=num % 10;
            sum+=currentDigit;
            num = num/10;
        }
        if (sum % 8 ==0){
            return true;
        }else {
            return false;
        }
    }
}
