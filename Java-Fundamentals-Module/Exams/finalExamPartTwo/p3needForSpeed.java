package finalExamPartTwo;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p3needForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String,Integer> nameF = new TreeMap<>();
        Map <String,Integer> nameM = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String [] car = scanner.nextLine().split("\\|");
            String name =car[0];
            int mileage = Integer.parseInt(car[1]);
            int fuel = Integer.parseInt(car[2]);

            nameF.put(name,fuel);
            nameM.put(name,mileage);
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")){
            String [] token = input.split(" : ");
            String command = token[0];
            String car = token[1];
            int distance1Fuel1Kilometers = Integer.parseInt(token[2]);

            int currentFuel = nameF.get(car);
            int currentMileage = nameM.get(car);

            switch (command){
                case "Drive":
                    int fuel = Integer.parseInt(token[3]);
                    if (fuel< currentFuel){
                        nameF.put(car,currentFuel-fuel);
                        nameM.put(car,currentMileage+distance1Fuel1Kilometers);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n",car,distance1Fuel1Kilometers,fuel);
                        if (nameM.get(car) >= 100000){
                            nameF.remove(car);
                            nameM.remove(car);
                            System.out.printf("Time to sell the %s!\n",car);
                        }
                    }
                    else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;
                case "Refuel":
                    if (currentFuel+distance1Fuel1Kilometers <= 75){
                        nameF.put(car,currentFuel+distance1Fuel1Kilometers);
                        System.out.printf("%s refueled with %d liters\n",car,distance1Fuel1Kilometers);
                    }
                    else {
                        System.out.printf("%s refueled with %d liters\n",car,75-currentFuel);
                        nameF.put(car,75);
                    }
                    break;
                case "Revert":
                    if (currentMileage - distance1Fuel1Kilometers >= 10000){
                        System.out.printf("%s mileage decreased by %d kilometers\n",car,distance1Fuel1Kilometers);
                        nameM.put(car,currentMileage-distance1Fuel1Kilometers);
                    }
                    else {
                        nameM.put(car,10000);
                    }
                    break;
            }
            input= scanner.nextLine();
        }
        nameM.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(x -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",x.getKey(),x.getValue(),nameF.get(x.getKey())));
    }
}
