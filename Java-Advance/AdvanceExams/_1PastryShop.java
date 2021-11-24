package AdvanceExams;

import java.util.*;
import java.util.stream.Collectors;

public class _1PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //liquids -queue
        //ingredients -stack
        Map<String,Integer> cookingStat = new LinkedHashMap<>();
        fillMap(cookingStat);


        ArrayDeque<Integer> queueLiquid = new ArrayDeque<>();
        ArrayDeque<Integer> stackIngredients = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(queueLiquid::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(stackIngredients::push);


        while (queueLiquid.size()>0){
            int liquid = queueLiquid.pop();
            int ingredient = stackIngredients.poll();
            int result = liquid+ingredient;
            boolean noMoreMat= false;

            String type;
            if (result == 25){
                type = "Biscuit";
                cookingStat.put(type,cookingStat.get(type) + 1);
            }
            else if (result == 50){
                type = "Cake";
                cookingStat.put(type,cookingStat.get(type) + 1);
            }
            else if (result == 75){
                type = "Pastry";
                cookingStat.put(type,cookingStat.get(type) + 1);
            }
            else if (result == 100){
                type = "Pie";
                cookingStat.put(type,cookingStat.get(type) + 1);
            }
            else {
                stackIngredients.push(ingredient + 3);
            }

            if (queueLiquid.isEmpty() || stackIngredients.isEmpty()){
                noMoreMat = true;
                break;
            }
        }
        if (!failWithCooing(cookingStat)){
            System.out.println("Great! You succeeded in cooking all the food!");
        }
        else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        printLiquid(queueLiquid);
        printIngredient(stackIngredients);
        printCookingStat(cookingStat);
    }

    private static void printCookingStat(Map<String, Integer> cookingStat) {
        for (Map.Entry<String, Integer> entry : cookingStat.entrySet()) {
            System.out.printf("%s: %d\n",entry.getKey(),entry.getValue());
        }
    }

    private static void fillMap(Map<String,Integer> map){
        map.put("Biscuit",0);
        map.put("Cake",0);
        map.put("Pie",0);
        map.put("Pastry",0);
    }

    private static boolean failWithCooing(Map<String,Integer> map){
        boolean fail = false;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0){
                fail= true;
            }
        }
        return fail;
    }
    private static void printLiquid(ArrayDeque<Integer> queue){
        System.out.print("Liquids left: ");
        if (queue.isEmpty()){
            System.out.print("none");
        }
        else {
            while (!queue.isEmpty()){
                if (queue.size() > 1){
                    System.out.print(queue.poll() + ", ");
                }
                else {
                    System.out.print(queue.poll());
                }
            }
        }
        System.out.println();
    }
    private static void printIngredient(ArrayDeque<Integer> stack){
        System.out.print("Ingredients left: ");
        if (stack.isEmpty()){
            System.out.print("none");
        }
        else {
            while (!stack.isEmpty()){
                if (stack.size() > 1){
                    System.out.print(stack.pop() + ", ");
                }
                else {
                    System.out.print(stack.pop());
                }
            }
        }
        System.out.println();
    }
}
