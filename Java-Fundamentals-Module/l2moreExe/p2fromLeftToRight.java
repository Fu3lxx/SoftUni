package l2moreExe;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class p2fromLeftToRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String [] nums = scanner.nextLine().split(" ");


            BigInteger num1 = new BigInteger(nums[0]);
            BigInteger num2 = new BigInteger(nums[1]);

            int compareValue = num1.compareTo(num2);

            if (compareValue > 0){
                int sum = 0;
                char [] temp = ("" + num1).toCharArray();
                for (int j = 0; j < temp.length; j++) {
                    sum += Integer.parseInt(String.valueOf(temp[j]));
                }
                System.out.println(sum);
            }else {
                int sum = 0;
                char [] temp = ("" + num2).toCharArray();
                for (int j = 0; j < temp.length; j++) {
                    sum += Integer.parseInt(String.valueOf(temp[j]));
                }
                System.out.println(sum);
            }

        }
    }
}
