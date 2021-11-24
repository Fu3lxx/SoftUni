package finalExamPartTwo;

import java.util.*;

public class p3plantDiscovery {
    public static class Plant implements Comparable<Plant>{
        public Plant(int rarity, String name) {
            this.rarity = rarity;
            this.name = name;
        }


        public void addRating (double rating){ratings.add(rating);}
        public void reset (){ratings.clear();}

        public int getRarity() {
            return rarity;
        }

        public double getAverage() {
            return average;
        }

        public String getName() {
            return name;
        }


        private List<Double> ratings = new ArrayList<>();

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        private int rarity;
        private  String name;

        public void computeAverage () {
            this.average = ratings.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        }

        private  double average;

        @Override
        public int compareTo(Plant o) {
            if (this.rarity > o.rarity){
                return 1;
            }
            else if (this.rarity < o.rarity){
                return -1;
            }
            else {
                if (this.average > o.average){
                    return 1;
                }
                else if (this.average < o.average){
                    return -1;
                }
                else {
                    return 0;
                }
            }

        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       Map<String,Plant> plantC = new HashMap<>();

        // Import data
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split("<->");
            String plantName = input[0];
            int rarity = Integer.parseInt(input[1]);
            plantC.put(plantName,new Plant(rarity,plantName));
        }

        // Receive commands
        String input = scanner.nextLine();
        while (!input.equals("Exhibition")){
            String [] token = input.split(": ");
            String command = token[0];

            // Check if the command is valid
            String plantNameEr =token[1].split(" - ")[0];
            if (!plantC.containsKey(plantNameEr)){
                System.out.println("error");
                input = scanner.nextLine();
                continue;
            }

            // Different commands
            switch (command){
                case "Rate":
                    String [] tokenR = token[1].split(" - ");
                    String plantName = tokenR[0];
                    double rating = Double.parseDouble(tokenR[1]);
                    plantC.get(plantName).addRating(rating);

                    break;

                case "Update":
                    String [] tokenU = token[1].split(" - ");
                    String plantName1 = tokenU[0];
                    int  newRarity = Integer.parseInt(tokenU[1]);
                    plantC.get(plantName1).setRarity(newRarity);
                    break;

                case "Reset":
                    String plantName2 = token[1];
                    plantC.get(plantName2).reset();
                    break;

                default:
                    System.out.println("error");
                    break;

            }

            input = scanner.nextLine();
        }

        // Sort and print
        System.out.println("Plants for the exhibition:");
        plantC.forEach((k,v)-> v.computeAverage());
        List <Plant> plants = new ArrayList<>(plantC.values());
        plants.sort(Comparator.reverseOrder());

        plants.forEach((plant -> System.out.printf("- %s; Rarity: %d; Rating: %.2f\n",plant.getName(),plant.getRarity(),plant.getAverage())));
    }
}
