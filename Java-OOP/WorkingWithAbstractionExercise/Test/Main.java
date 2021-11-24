package WorkingWithAbstractionExercise.Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bag bag = new Bag(100);

        for (int i = 0; i < 3; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String gemName = info[0];
            int amount = Integer.parseInt(info[1]);
            Gem gem = new Gem(gemName,amount);
            bag.addGem(gem);
        }
        bag.printGems();
    }
}
