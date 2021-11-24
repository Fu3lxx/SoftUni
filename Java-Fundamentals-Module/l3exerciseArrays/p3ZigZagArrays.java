package l3exerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class p3ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];


        for (int i = 0; i <arr1.length; i++) {
            //String text= scanner.nextLine();

            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (i % 2 == 0){
                arr1[i]=arr[0];
                arr2[i]=arr[1];
            }
            else {
                arr2[i]=arr[0];
                arr1[i]=arr[1];
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i <arr2.length ; i++) {
            System.out.print(arr2[i] + " ");
        }

    }
}
