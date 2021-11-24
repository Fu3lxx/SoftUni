package l8textProcessingEcercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p2characterMultiplier {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        String [] text = scanner.nextLine().split("\\s+");

        char [] first = text[0].toCharArray();
        char [] second = text[1].toCharArray();
        int sum = 0;
        int index = 0;
        if (first.length> second.length){
            index = first.length;
        }else {
            index = second.length;
        }

        for (int i = 0; i < index; i++) {
            if (i < first.length && i < second.length){
                int firstSymbol = first[i];
                int secondSymbol = second[i];
                sum+= firstSymbol*secondSymbol;
            }
            else if (first.length-1 < i ){
                sum+= second[i];
            }
            else {
                sum+= first[i];
            }

        }
        System.out.println(sum);



    }
}
