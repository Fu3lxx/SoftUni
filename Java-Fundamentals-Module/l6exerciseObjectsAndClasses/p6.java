package l6exerciseObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicleList = new ArrayList<>();
        List<Vehicle> truckList = new ArrayList<>();
        int totalCars =0;
        int totalTrucks=0;
        double totalCarHp=0;
        double totalTruckHp=0;
        while (true){
            String input= scanner.nextLine();
            if (input.equals("End")){
                break;
            }
            String[] data =input.split("\\s+");
            Vehicle currentVehicle = new Vehicle(data[0],data[1],data[2],Integer.parseInt(data[3]));
            if (data[0].equals("car")){
                vehicleList.add(currentVehicle);
                totalCars++;
                totalCarHp+=Double.parseDouble(data[3]);
            }
            else {
                truckList.add(currentVehicle);
                totalTrucks++;
                totalTruckHp+=Double.parseDouble(data[3]);
            }

        }
        while (true){
            String catalog= scanner.nextLine();
            if (catalog.equals("Close the Catalogue")){
                break;
            }
            for (Vehicle currentCar :vehicleList){
                if (catalog.equals(currentCar.getModel())){
                    System.out.println(currentCar.toString());
                }
            }
            for (Vehicle currentTruck :truckList){
                if (catalog.equals(currentTruck.getModel())){
                    System.out.println(currentTruck.toString());
                }
            }

        }
        System.out.printf("Cars have average horsepower of: %.2f.\n",totalCarHp/totalCars);
        System.out.printf("Trucks have average horsepower of: %.2f.",totalTruckHp/totalTrucks);
    }
}
