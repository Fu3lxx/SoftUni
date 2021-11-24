package stackAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = input.length -1; i >=0 ; i--) {
            stack.push(input[i]);
        }

        while (stack.size() > 1){
            int leftNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int rightNum = Integer.parseInt(stack.pop());

            int result = operator.equals("+")
                    ? leftNum + rightNum
                    : leftNum - rightNum;

            stack.push(String.valueOf(result));
        }

        System.out.println(stack.pop());
    }
}
