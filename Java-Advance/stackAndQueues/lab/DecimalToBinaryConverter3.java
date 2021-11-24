package stackAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());

        ArrayDeque <Integer> stack = new ArrayDeque<>();
        if (a == 0){
            System.out.println(a);
            return;
        }


        while (a != 0){
            stack.push(a % 2);
            a /= 2;
        }


        for (Integer num :stack){
            System.out.print(num);
        }
    }
}
