package l3exerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class p6EqualSums {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean equalNum=false;

        for (int i = 0; i <array.length ; i++) {
            int sumRight=0;
            int sumLeft=0;

            for (int right = i; right < array.length-1; right++) {
                sumRight+=array[right+1];
            }
            for (int left = i; left >0 ; left--) {
                sumLeft+=array[left-1];
            }
            if (sumRight==sumLeft){
                System.out.print(i);
                equalNum=true;
                break;
            }
        }
        if (!equalNum){
            System.out.print("no");
        }
    }
}
