package stackAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque <Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int [] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (input[0] == 1){
                int numToPush = input[1];
                stack.push(numToPush);
            }
            else if (input[0] == 2){
                stack.pop();
            }
            else if (input[0] == 3){
                if (!stack.isEmpty()){
                    System.out.println(Collections.max(stack));
                }
            }


        }
    }
}
