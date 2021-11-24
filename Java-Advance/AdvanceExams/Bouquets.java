package AdvanceExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stackTulips = new ArrayDeque<>();
        ArrayDeque<Integer> queueDaffodils = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(stackTulips::push);
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(queueDaffodils::offer);
        int bouquets = 0;
        int flowersLeft = 0;

        while (!stackTulips.isEmpty() || !queueDaffodils.isEmpty() || bouquets == 5){
            if (stackTulips.isEmpty() || queueDaffodils.isEmpty()){
                break;
            }
            int tulips = stackTulips.pop();
            int daffodils = queueDaffodils.peek();

            if (tulips + daffodils == 15){
                queueDaffodils.poll();
                bouquets++;
            }
            else if (tulips + daffodils < 15){
                queueDaffodils.poll();
                flowersLeft += tulips + daffodils;
            }
            else if (tulips + daffodils > 15){
                while (true){
                    tulips-= 2;
                    if (tulips + daffodils == 15){
                        bouquets++;
                        queueDaffodils.poll();
                        break;
                    }
                    else if (tulips + daffodils < 15){
                        queueDaffodils.poll();
                        flowersLeft += tulips + daffodils;
                        break;
                    }
                }
            }
        }
        bouquets += flowersLeft / 15;

        if (bouquets >= 5){
            System.out.println("You made it! You go to the competition with 5 bouquets!");
        }
        else {
            System.out.printf("You failed... You need more %d bouquets.",5-bouquets);
        }

    }
}
