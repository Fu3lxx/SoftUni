package l3exerciseArrays;

import java.util.Scanner;

public class p2CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1= scanner.nextLine();
        String[] arr1= input1.split(" ");

        String input2 = scanner.nextLine();
        String[] arr2 = input2.split(" ");


        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j <arr1.length; j++) {
                if (arr1[j].equals(arr2[i])){
                    System.out.print(arr2[i] + " ");
                }

            }

        }

    }
}
