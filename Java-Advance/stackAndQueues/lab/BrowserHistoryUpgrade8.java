package stackAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque <String> browserHistory = new ArrayDeque<>();
        ArrayDeque <String> forward = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("Home")){

            if (input.equals("forward")){
                if (forward.size() < 1){
                    System.out.println("no next URLs");
                }
                else {
                    browserHistory.push(forward.pop());
                    System.out.println(browserHistory.peek());
                }
            }
            else if (input.equals("back")){
                if (browserHistory.size() < 2){
                    System.out.println("no previous URLs");
                }
                else {
                    forward.addFirst(browserHistory.peek());
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                }
            }
            else {
                browserHistory.push(input);
                System.out.println(browserHistory.peek());
                forward.clear();
            }

            input= scanner.nextLine();
        }
    }
}
