package l1excerciseStatementsAndLoops;

import java.util.Scanner;

public class p10RageExpenses {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int gamesLose = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int countHeadsets = gamesLose / 2;
        int countMice = gamesLose / 3;
        int countKeyboards = gamesLose / 6;
        int countMonitors = gamesLose / 12;


        double expenses = (countHeadsets * headsetPrice)
                + (countMice * mousePrice)
                + (countKeyboards * keyboardPrice)
                + (countMonitors * displayPrice);

        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}
