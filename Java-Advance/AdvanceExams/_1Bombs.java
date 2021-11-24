package AdvanceExams;

import java.util.*;
import java.util.stream.Collectors;

public class _1Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> bombCount = new TreeMap<>();
        bombCount.put("Datura Bombs",0);
        bombCount.put("Cherry Bombs",0);
        bombCount.put("Smoke Decoy Bombs",0);

        ArrayDeque<Integer> bombEffectQ = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasingS = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombEffectQ::offer);
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombCasingS::push);

        while (!bombEffectQ.isEmpty() || !bombCasingS.isEmpty()){
            if (bombEffectQ.isEmpty() || bombCasingS.isEmpty() || bombsReady(bombCount)){
                break;
            }
            int effect = bombEffectQ.poll();
            int casing = bombCasingS.pop();
            int sum = effect+casing;

            switch (sum){
                case 40:
                    bombCount.put("Datura Bombs",bombCount.get("Datura Bombs") + 1);
                    break;
                case  60:
                    bombCount.put("Cherry Bombs", bombCount.get("Cherry Bombs") + 1);
                    break;
                case 120:
                    bombCount.put("Smoke Decoy Bombs",bombCount.get("Smoke Decoy Bombs") + 1);
                    break;
                default:
                    bombCasingS.push(casing - 5);
                    bombEffectQ.addFirst(effect);
                    break;
            }
        }
        if (bombsReady(bombCount)){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }
        else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffectQ.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else {
            System.out.print("Bomb Effects: " + bombEffectQ.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();
        }

        if (bombCasingS.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else {
            System.out.print("Bomb Casings: " + bombCasingS.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();
        }

        bombCount.forEach((key,value) -> System.out.println(key + ": " + value));


    }
    private static boolean bombsReady(Map<String, Integer> bombs){
        boolean ready = true;
        for (var bomb:bombs.entrySet()){
            if (bomb.getValue() < 3){
                ready = false;
            }
        }
        return ready;
    }
}
