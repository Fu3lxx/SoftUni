package finalExams.first;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p3needForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Integer> nameF = new TreeMap<>();
        Map <String,Integer> mileage = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split("\\|");
            String carName = input[0];
            int carMileage = Integer.parseInt(input[1]);
            int fuelAvailable = Integer.parseInt(input[2]);

            nameF.put(carName,fuelAvailable);
            mileage.put(carName,carMileage);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")){
            String [] token = input.split(" : ");

            String command = token[0];
            String carName = token[1];
            int command3h = Integer.parseInt(token[2]);
            int currentFuel = nameF.get(carName);
            int currentMileage = mileage.get(carName);


            switch (command){
                case "Drive":
                    int fuelNeeded = Integer.parseInt(token[3]);
                    if (currentFuel >= fuelNeeded){
                        mileage.put(carName,currentMileage + command3h);
                        nameF.put(carName, currentFuel - fuelNeeded);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n",carName,command3h,fuelNeeded);
                        if (mileage.get(carName) >= 100000){
                            nameF.remove(carName);
                            mileage.remove(carName);
                            System.out.printf("Time to sell the %s!\n",carName);
                        }
                    }
                    else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;
                case "Refuel":
                    if (currentFuel + command3h >75){
                        System.out.printf("%s refueled with %d liters\n",carName,75-currentFuel);
                        nameF.put(carName,75);
                    }
                    else {
                        System.out.printf("%s refueled with %d liters\n",carName,command3h);
                        nameF.put(carName,currentFuel+command3h);
                    }
                    break;
                case "Revert":
                    if (currentMileage-command3h < 10000){
                        mileage.put(carName,10000);
                    }else {
                        mileage.put(carName,currentMileage-command3h);
                        System.out.printf("%s mileage decreased by %d kilometers\n",carName,command3h);
                    }
                    break;
                default:
                    break;


            }

            input= scanner.nextLine();
        }

        mileage.entrySet().stream().sorted((a,b) -> b.getValue() - a.getValue())
                .forEach(car -> {
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",car.getKey(),car.getValue(),nameF.get(car.getKey()));
                });


    }
}
