package AdvanceExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _1MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstMagicBox = new ArrayDeque<>(); //queue
        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>(); // stack

        int collection = 0;

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(firstMagicBox::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(secondMagicBox::push);
        int n = 16 % 2;

        while (true){
            int first = firstMagicBox.peek();
            int second = secondMagicBox.pop();

            if ((first+second) % 2 == 0){
                firstMagicBox.poll();
                collection+= first+ second;
            }
            else {
                firstMagicBox.addLast(second);
            }

            if (firstMagicBox.isEmpty() || secondMagicBox.isEmpty()){
                break;
            }
        }
        if (firstMagicBox.isEmpty()){
            System.out.println("First magic box is empty.");
        }
        if (secondMagicBox.isEmpty()){
            System.out.println("Second magic box is empty.");
        }

        if (collection >= 90){
            System.out.println("Wow, your prey was epic! Value: " + collection);
        }
        else {
            System.out.println("Poor prey... Value: " + collection);
        }
    }
}
