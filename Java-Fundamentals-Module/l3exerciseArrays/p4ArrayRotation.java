package l3exerciseArrays;

import java.util.Scanner;

public class p4ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String text = scanner.nextLine();
       String[] array=text.split(" ");
       int rotation =Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <=rotation ; i++) {
            String temp=array[0];

            for (int j = 0; j <array.length-1 ; j++) {
                array[j]=array[j+1];
            }
            array[array.length-1]=temp;

        }
        System.out.println(String.join(" ",array));
        for (int i = 0; i <array.length ; i++) {
         System.out.print(array[i] + " ");
        }

        for (String tova : array){
            System.out.print(tova + " ");
        }

    }
}
