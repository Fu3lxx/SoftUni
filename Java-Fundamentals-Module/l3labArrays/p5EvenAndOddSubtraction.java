package l3labArrays;

import java.util.Arrays;
import java.util.Scanner;

public class p5EvenAndOddSubtraction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String num= scanner.nextLine();

        int[] number= Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int evenSum=0;
        int oddSum=0;

        for (int i = 0; i <number.length ; i++) {
            if (number[i]%2==0){
                evenSum+=number[i];
            }else oddSum+=number[i];
        }
        System.out.println(evenSum-oddSum);
    }
}
