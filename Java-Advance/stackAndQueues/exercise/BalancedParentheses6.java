package stackAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean balance = false;

        for (int i = 0; i <input.length() ; i++) {
            char current = input.charAt(i);

            if (current == '{' || current == '(' || current == '['){
                stack.push(current);
            }
            else if (current == '}' || current == ')' || current == ']'){
                if (stack.isEmpty()){
                    System.out.println("NO");
                    return;
                }
                char lastOpen = stack.pop();

                if (current == ')' && lastOpen == '('){
                    balance=true;
                }
                else if (current == '}' && lastOpen == '{'){
                    balance=true;
                }
                else if (current == ']' && lastOpen == '['){
                    balance=true;
                }

                if (!balance){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
