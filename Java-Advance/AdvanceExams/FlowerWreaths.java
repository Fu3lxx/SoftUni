package AdvanceExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(liliesStack::push);
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(rosesQueue::offer);
        int wreath = 0;
        int extra = 0;

        while (true){
            int lilies = liliesStack.pop();
            int roses =rosesQueue.poll();

            if (lilies + roses == 15){
                wreath++;
            }
            else if (lilies + roses < 15){
                extra += roses + lilies;
            }
            else if (lilies + roses > 15){
                while (true){
                    lilies -= 2;
                    if (lilies+roses == 15){
                        wreath++;
                        break;
                    }
                    else if (lilies + roses < 15){
                        extra += lilies + roses;
                        break;
                    }
                }
            }
            if (rosesQueue.size() ==0 || liliesStack.size() == 0 || wreath >= 5){
                break;
            }
        }
        wreath += extra / 15;
        if (wreath >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!",wreath);
        }
        else {
            System.out.printf("You didn't make it, you need %d wreaths more!",5 - wreath);
        }
    }
}
