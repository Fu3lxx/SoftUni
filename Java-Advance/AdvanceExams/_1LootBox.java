package AdvanceExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _1LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQ  = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxS = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(firstBoxQ::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(secondBoxS::push);

        int loot = 0;

        while (!firstBoxQ.isEmpty() || !secondBoxS.isEmpty()){
            if (firstBoxQ.isEmpty() || secondBoxS.isEmpty()){
                break;
            }
            int firstItemQ  = firstBoxQ.peek();
            int secondItemS = secondBoxS.pop();
            int sum = firstItemQ+secondItemS;
            if (sum % 2 ==0){
                firstBoxQ.poll();
                loot += sum;
            }else {
                firstBoxQ.addLast(secondItemS);
            }

        }
        if (firstBoxQ.isEmpty()){
            System.out.println("First lootbox is empty");
        }
        else if (secondBoxS.isEmpty()){
            System.out.println("Second lootbox is empty");
        }

        if (loot >= 100){
            System.out.printf("Your loot was epic! Value: %d",loot);
        }
        else {
            System.out.printf("Your loot was poor... Value: %d",loot);
        }
    }
}
