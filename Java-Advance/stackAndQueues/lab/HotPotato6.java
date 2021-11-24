package stackAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String [] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String name:input){
            queue.offer(name);
        }
        int n = Integer.parseInt(scanner.nextLine());

        while (queue.size() > 1){
            for (int i = 1; i < n ; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
        
    }
}
