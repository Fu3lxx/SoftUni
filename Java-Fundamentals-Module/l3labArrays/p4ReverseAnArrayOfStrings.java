package l3labArrays;

import java.util.Scanner;

public class p4ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text = scanner.nextLine();

        String[] array=text.split(" ");

        for (int i = 0; i < array.length/2; i++) {
            String temp=array[i];

            array[i]=array[array.length-i-1];
            array[array.length-i-1]=temp;

        }
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i] + " ");
        }


    }
}
