package Polimorphism_Exercise.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] token = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(token[1]), Double.parseDouble(token[2]));
        token = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(token[1]), Double.parseDouble(token[2]));

        int commands = Integer.parseInt(scanner.nextLine());
        while (commands-- > 0) {
            token = scanner.nextLine().split("\\s+");
            double amount = Double.parseDouble(token[2]);
            if (token[0].contains("Drive")){
                if (token[1].equals("Polimorphism_Exercise.VehiclesExtension.Car")){
                    System.out.println(car.drive(amount));
                }else {
                    System.out.println(truck.drive(amount));
                }
            }else {
                if (token[1].equals("Polimorphism_Exercise.VehiclesExtension.Car")){
                    car.refuel(amount);
                }else {
                    truck.refuel(amount);
                }
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
