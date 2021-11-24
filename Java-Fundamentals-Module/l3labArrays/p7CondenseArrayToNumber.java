package l3labArrays;

import java.util.Arrays;
import java.util.Scanner;

public class p7CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr= Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                arr[j]= arr[j] + arr[j+1];
            }
        }
        System.out.println(arr[0]);
    }
}
