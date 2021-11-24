package SetsAndMaps.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")){
            String car = input.split(" ")[1];
            if (input.contains("IN")){
                parking.add(car);
            }
            else {
                parking.remove(car);
            }

            input= scanner.nextLine();
        }
        if (parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        else {
            for (var car:parking){
                System.out.println(car);
            }
        }

    }
}
