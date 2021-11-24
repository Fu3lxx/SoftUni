package l3exerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class p10KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length=Integer.parseInt(scanner.nextLine());


        String sequence= scanner.nextLine();
        int[] best=new int[length];
        while (!sequence.equals("Clone them!")){
            String[] arrayS = sequence.split("!");
            int[] array = Arrays.stream(arrayS).mapToInt(Integer::parseInt).toArray();

            int currentLong=1;
            int longestLong=0;
            int minIndex=100;


            for (int i = 1; i <array.length ; i++) {
                if (array[i-1]==array[i]){
                    currentLong++;

                    if (currentLong>longestLong){
                        longestLong=currentLong;
                        if (minIndex>i){
                            minIndex=i;
                            best=array;
                        }

                    }
                }else {
                    currentLong=1;
                }

            }

        sequence= scanner.nextLine();
        }
        for (int i = 0; i <length ; i++) {
            System.out.print(best[i]+ " ");

        }







    }
}
