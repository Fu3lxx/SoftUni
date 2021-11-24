package finalExams.first;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p3pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String , Integer> mapN = new TreeMap<>();
        Map <String , Integer> mapG = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Sail")){
            String [] token = input.split("\\|\\|");
            String town = token[0];
            int gold = Integer.parseInt(token[2]);
            int population = Integer.parseInt(token[1]);
            if (mapG.containsKey(town)){
                mapN.put(town,population+mapN.get(town));
                mapG.put(town,gold+mapG.get(town));
            }else {
                mapN.put(town,population);
                mapG.put(town,gold);
            }


            input= scanner.nextLine();
        }

        String input2 = scanner.nextLine();
        while (!input2.equals("End")){
            String [] token = input2.split("=>");
            String command = token[0];
            String city = token[1];

            int currentG = mapG.get(city);
            int currentP = mapN.get(city);

            if (command.equals("Plunder")){
                int population = Integer.parseInt(token[2]);
                int gold = Integer.parseInt(token[3]);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n",city,gold,population);

                currentG-= gold;
                currentP-= population;
                mapG.put(city,currentG);
                mapN.put(city,currentP);
                if (currentG<=0 || currentP <=0){
                    System.out.printf("%s has been wiped off the map!\n",city);
                    mapG.remove(city);
                    mapN.remove(city);
                }
            }

            else if (command.equals("Prosper")){
                int amount = Integer.parseInt(token[2]);
                if (amount>=0){
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n",amount,city,currentG+amount);
                    mapG.put(city,currentG+amount);
                }else {
                    System.out.println("Gold added cannot be a negative number!");
                }
            }

            input2 = scanner.nextLine();
        }
        if (mapG.size()>0){
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n",mapG.size());

            mapG.entrySet().stream()
                    .sorted(Map.Entry.<String,Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                    .forEach(s -> {
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n",s.getKey(),mapN.get(s.getKey()),s.getValue());
                    });

        }

    }
}
