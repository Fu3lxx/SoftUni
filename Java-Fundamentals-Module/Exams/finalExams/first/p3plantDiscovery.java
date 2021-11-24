package finalExams.first;

import java.util.*;

public class p3plantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int times = Integer.parseInt(scanner.nextLine());
        Map <String, Integer> mapRarity = new HashMap<>();
        Map <String, List<Double>> mapRating = new HashMap<>();


        // Import map data
        for (int i = 0; i < times; i++) {
            String[] input = scanner.nextLine().split("<->");
            String name = input[0];
            int rarity = Integer.parseInt(input[1]);

            mapRarity.compute(name, (k,v) -> rarity);
            mapRating.putIfAbsent(name,new ArrayList<>());
        }
        String input = scanner.nextLine();


        // Some commands
        while (!input.equals("Exhibition")){
            String [] token = input.split(": ");
            String command = token[0];
            String plantName =token[1].split(" - ")[0];

            if (!mapRarity.containsKey(plantName)){
                System.out.println("error");
                continue;
            }

            if (command.equals("Rate")){
                Double rating = Double.parseDouble(token[1].split(" - ")[1]);
                mapRating.get(plantName).add(rating);
            }
            else if (command.equals("Update")){
                int newRarity = Integer.parseInt(token[1].split(" - ")[1]);
                mapRarity.compute(plantName,(k,v) -> newRarity);

            }
            else if (command.equals("Reset")){
                mapRating.get(plantName).clear();
            }
            else {
                System.out.println("error");
            }

            input= scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");


        // Sort
        mapRarity.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().thenComparingDouble(x -> mapRating.get(x.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0)).reversed())
                .forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",e.getKey(),e.getValue(),mapRating.get(e.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));
    }
}
