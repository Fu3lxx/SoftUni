package l4labMethods;

import java.util.Scanner;

public class multiplyEvenByOdds {
    public  static int getEvenSum (int n){
        int evenSum=0;
        int[] digits = Integer.toString(n).chars().map(c -> c-'0').toArray();
        for (int i = 0; i <digits.length ; i++) {
            if (digits[i]%2==0){
                evenSum+=Math.abs(digits[i]);
            }
        }
        return evenSum;
    }
    public static int getOddSum(int n){
        int oddSum=0;
        int[] digits = Integer.toString(n).chars().map(c -> c-'0').toArray();
        for (int i = 0; i <digits.length; i++) {
            if (digits[i]%2!=0){
                oddSum+=Math.abs(digits[i]);
            }
        }
        return oddSum;
    }
    public static int getMultipleOfEvenAndOdd (int n){
        int evenSum= getEvenSum(n);
        int oddSum = getOddSum(n);
        return evenSum*oddSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Math.abs(Integer.parseInt(scanner.nextLine()));
        System.out.println(getMultipleOfEvenAndOdd(n));
    }

}
