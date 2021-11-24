package l3exerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class p5TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i <arr.length ; i++) {
            boolean bigger=true;

            for (int j = i; j <arr.length ; j++) {
                if (arr[i] < arr[j]) {
                    bigger=false;
                }
            }
            if (bigger){
                System.out.print(arr[i] + " ");
            }

        }
    }
}
