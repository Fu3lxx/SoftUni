package WorkingWithAbstractionExercise.greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());
        Bag bag = new Bag(bagCapacity);
        Safe safe = new Safe(scanner.nextLine());

        while (!safe.safeIsEmpty()){
            String item = safe.getItem();
            int amount = safe.getAmount();
            String itemType = whatTypeOfItem(item.toLowerCase());
            switch (itemType){
                case "Gold":
                    bag.addGold(amount);
                    break;
                case "Gem":
                    bag.addGem(item,amount);
                    break;
                case "Cash":
                    bag.addCash(item,amount);
                    break;
            }
        }
        bag.printBagData();
    }

    private static String whatTypeOfItem(String itemName){
        if (itemName.length() == 3) {
            return  "Cash";
        } else if (itemName.endsWith("gem")) {
            return  "Gem";
        } else if (itemName.equals("gold")) {
            return "Gold";
        }
        return "trash";
    }
}
