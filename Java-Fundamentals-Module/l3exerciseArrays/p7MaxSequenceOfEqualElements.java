package l3exerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class p7MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int length=1;
        int maxLength=0;

        int equalElement=0;
        int bestElement=0;

        for (int i = 1; i <array.length ; i++) {
            int currentElement= array[i];

            if (array[i] == array[i-1]) {
                length++;
                equalElement=array[i];
            }else {
                length=1;
            }
            if (length>maxLength){
                maxLength=length;
                equalElement=currentElement;
                bestElement=currentElement;
            }

        }
        for (int i = 1; i <=maxLength ; i++) {
            System.out.print(bestElement+ " ");

        }
    }
}
