package SetsAndMaps.Exercise;

import java.util.*;

public class HandsOfCards8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> pAndCards = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")){
            String name = input.split(":")[0];
            String cardText = input.split(": ")[1];
            String[] cards = cardText.split(", ");

            for (int i = 0; i <cards.length ; i++) {
                if (!pAndCards.containsKey(name)) {
                    pAndCards.put(name, new LinkedHashSet<>());
                }
                pAndCards.get(name).add(cards[i]);
            }
            input= scanner.nextLine();
        }
        Map<String,Integer> pAndScore = new LinkedHashMap<>();
        for (Map.Entry<String,Set<String>> name: pAndCards.entrySet()){
            int points = getPoints(name.getValue());
            System.out.printf("%s: %d\n",name.getKey(),points);
        }
    }

    private static int getPoints(Set<String> value) {
        int sum = 0;
        Map<Character,Integer> pointsValue = getPointsValue();
        for (var card: value){
            if (card.contains("10")){
                char strength = card.charAt(2);
                sum += 10 * pointsValue.get(strength);
            }
            else {
                char number = card.charAt(0);
                char power = card.charAt(1);
                sum+= pointsValue.get(number) * pointsValue.get(power);
            }
        }
        return sum;
    }

    private static Map<Character, Integer> getPointsValue() {
        Map<Character,Integer> points = new HashMap<>();
        points.put('1',1);
        points.put('2',2);
        points.put('3',3);
        points.put('4',4);
        points.put('5',5);
        points.put('6',6);
        points.put('7',7);
        points.put('8',8);
        points.put('9',9);
        points.put('J',11);
        points.put('Q',12);
        points.put('K',13);
        points.put('A',14);

        points.put('S',4);
        points.put('H',3);
        points.put('D',2);
        points.put('C',1);
        return points;
    }
}
