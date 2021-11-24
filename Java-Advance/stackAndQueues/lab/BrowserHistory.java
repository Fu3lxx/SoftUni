package stackAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        String current = "";

        while (!input.equals("Home")){

            if (input.equals("back")) {
                if (stack.size()<2){
                    System.out.println("no previous URLs");
                    input= scanner.nextLine();
                    continue;
                }
                else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            }
            else {
                stack.push(input);
                System.out.println(stack.peek());

            }

            input= scanner.nextLine();
        }
    }
}
