package exams;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class kaminoFactory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize =Integer.parseInt(scanner.nextLine());

        int bestIndex= Integer.MAX_VALUE;
        int sum =0;
        int bestMach=0;
        int [] bestDna = new int[arraySize];
        int bestRow =0;
        int currentRow =0;

        String input = scanner.nextLine();
        while (!input.equals("Clone them!")){
            currentRow++;
            int [] currentDna = Arrays.stream(input.split("!+")).mapToInt(Integer::parseInt).toArray();

            int currentStartingIndex =0;
            int currentMaxMach=1;
            int currentSum=0;

            for (int i = 0; i <currentDna.length-1 ; i++) {
                if (currentDna[i] == currentDna[i+1] && currentDna[i] !=0){
                    currentStartingIndex=i;
                    currentMaxMach++;
                }
            }
            for (int n :currentDna){
                currentSum+=n;
            }

            if (currentMaxMach > bestMach){
                bestMach=currentMaxMach;
                bestIndex=currentStartingIndex;
                sum = currentSum;
                bestDna=currentDna;
                bestRow=currentRow;
            }
            else if (currentMaxMach == bestMach && currentStartingIndex< bestIndex){
                bestMach=currentMaxMach;
                bestIndex=currentStartingIndex;
                sum = currentSum;
                bestDna=currentDna;
                bestRow=currentRow;
            }
            else if (currentMaxMach == bestMach && currentStartingIndex ==bestIndex && currentSum > sum){
                bestMach=currentMaxMach;
                bestIndex=currentStartingIndex;
                sum = currentSum;
                bestDna=currentDna;
                bestRow=currentRow;
            }





            input= scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n",bestRow,sum);
        for (int i :bestDna)
        System.out.print(i + " ");

    }
}
