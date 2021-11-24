package AdvanceExams;

import java.util.*;
import java.util.stream.Collectors;

public class _1Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> foodTable = new TreeMap<>();
        foodTable.put("Bread", 0);
        foodTable.put("Cake", 0);
        foodTable.put("Pastry", 0);
        foodTable.put("Fruit Pie", 0);

        ArrayDeque<Integer> liquidsQ = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsS = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(liquidsQ::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredientsS::push);

        while (liquidsQ.size() > 0 || ingredientsS.size() > 0) {
            if (liquidsQ.isEmpty() || ingredientsS.isEmpty()){
                break;
            }
            int liquid = liquidsQ.poll();
            int ingredient = ingredientsS.pop();
            int sum = liquid + ingredient;

            switch (sum) {
                case 25:
                    foodTable.put("Bread", foodTable.get("Bread") + 1);
                    break;
                case 50:
                    foodTable.put("Cake", foodTable.get("Cake") + 1);
                    break;
                case 75:
                    foodTable.put("Pastry", foodTable.get("Pastry") + 1);
                    break;
                case 100:
                    foodTable.put("Fruit Pie", foodTable.get("Fruit Pie") + 1);
                    break;
                default:
                    ingredientsS.push(ingredient + 3);
                    break;
            }
        }
        boolean oneFromEach = true;
        for (var food : foodTable.entrySet()) {
            if (food.getValue() < 1) {
                oneFromEach = false;
            }
        }
        if (oneFromEach) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQ.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: " + liquidsQ.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();
        }
        if (ingredientsS.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: " + ingredientsS.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();
        }

        for (var food: foodTable.entrySet()){
            System.out.printf("%s: %d\n",food.getKey(),food.getValue());
        }

    }
}
