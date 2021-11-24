package Polimorphism_Exercise.VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] token = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(token[1]), Double.parseDouble(token[2]),Integer.parseInt(token[3]));
        token = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(token[1]), Double.parseDouble(token[2]),Integer.parseInt(token[3]));
        token = scanner.nextLine().split("\\s+");
        Vehicle bus = new Bus(Double.parseDouble(token[1]), Double.parseDouble(token[2]),Integer.parseInt(token[3]));

        int commands = Integer.parseInt(scanner.nextLine());
        while (commands-- > 0){
            token = scanner.nextLine().split("\\s+");
            double amount = Double.parseDouble(token[2]);

            switch (token[0]){
                case "Refuel":
                    if (token[1].contains("Polimorphism_Exercise.VehiclesExtension.Car")){
                        try {
                            car.refuel(amount);
                        }catch (IllegalArgumentException exception){
                            System.out.println(exception.getMessage());
                        }
                    }else if (token[1].contains("Polimorphism_Exercise.VehiclesExtension.Truck")){
                        try {
                            truck.refuel(amount);
                        }catch (IllegalArgumentException exception){
                            System.out.println(exception.getMessage());
                        }
                    }else {
                        try {
                            bus.refuel(amount);
                        }catch (IllegalArgumentException exception){
                            System.out.println(exception.getMessage());
                        }
                    }
                    break;
                case "Drive":
                    if (token[1].contains("Polimorphism_Exercise.VehiclesExtension.Car")){
                        try {
                            System.out.println(car.drive(amount));
                        }catch (IllegalArgumentException exception){
                            System.out.println(exception.getMessage());
                        }
                    }else if (token[1].contains("Polimorphism_Exercise.VehiclesExtension.Truck")){
                        try {
                            System.out.println(truck.drive(amount));
                        }catch (IllegalArgumentException exception){
                            System.out.println(exception.getMessage());
                        }
                    }else {
                        try {
                            bus.addFuelConsumption(1.4);
                            System.out.println(bus.drive(amount));
                            bus.removeFuelConsumption(1.4);
                        }catch (IllegalArgumentException exception){
                            System.out.println(exception.getMessage());
                        }
                    }
                    break;
                case "DriveEmpty":
                    try {
                        System.out.println(bus.drive(amount));
                    }catch (IllegalArgumentException exception){
                        System.out.println(exception.getMessage());
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
