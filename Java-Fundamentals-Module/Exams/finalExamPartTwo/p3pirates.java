package finalExamPartTwo;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p3pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , Integer> namePop = new TreeMap<>();
        Map<String , Integer> nameGold = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Sail")){
            String [] token = input.split("\\|\\|");
            String name = token[0];
            int population = Integer.parseInt(token[1]);
            int gold = Integer.parseInt(token[2]);

            if (!namePop.containsKey(name)){
                namePop.put(name,population);
                nameGold.put(name,gold);
            }else {
                int currentGold = nameGold.get(name);
                int currentPopulation = namePop.get(name);

                namePop.put(name,currentPopulation+population);
                nameGold.put(name,currentGold + gold);
            }
            input= scanner.nextLine();
        }

        String input2 = scanner.nextLine();
        while (!input2.equals("End")){
            String [] token = input2.split("=>");

            String command = token[0];
            String name = token[1];
            int currentGold = nameGold.get(name);
            int currentPopulation = namePop.get(name);

            switch (command){
                case "Plunder":
                    int people = Integer.parseInt(token[2]);
                    int gold = Integer.parseInt(token[3]);

                    namePop.put(name,currentPopulation-people);
                    nameGold.put(name,currentGold-gold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n",name,gold,people);

                    if (namePop.get(name) <= 0 | nameGold.get(name) <= 0){
                        namePop.remove(name);
                        nameGold.remove(name);
                        System.out.printf("%s has been wiped off the map!\n",name);
                    }
                    break;
                case "Prosper":
                    int gold1 = Integer.parseInt(token[2]);

                    if (gold1 >=0){
                        nameGold.put(name,currentGold+gold1);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n",gold1,name,nameGold.get(name));
                    }
                    else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }
            input2 = scanner.nextLine();
        }

        if (nameGold.size() > 0){
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n",nameGold.size());
            nameGold.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(x -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n",x.getKey(),namePop.get(x.getKey()),x.getValue()));
        }
    }
}
