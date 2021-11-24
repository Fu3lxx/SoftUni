package l8textProcessingEcercise;

import java.math.BigInteger;
import java.util.Scanner;

public class p5multiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger fistNum = new BigInteger(scanner.nextLine());
        BigInteger secondNum = new BigInteger(scanner.nextLine());

        BigInteger finalSum = fistNum.multiply(secondNum);
        System.out.println(finalSum);
    }
}
