package l6objectAndClassesLab;

import java.math.BigInteger;
import java.util.Scanner;

public class p3BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        BigInteger sum = new BigInteger("1");

        for (int i = 1; i <=num ; i++) {
            sum=sum.multiply(new BigInteger("" + i));
        }
        System.out.println(sum);
    }

}
