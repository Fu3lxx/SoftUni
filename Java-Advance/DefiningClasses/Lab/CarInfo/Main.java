package DefiningClasses.Lab.CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] token = scanner.nextLine().split("\\s+");
            String brand = token[0];
            String model = token[1];
            int horsePower = Integer.parseInt(token[2]);

            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHordePower(horsePower);

            System.out.println(car.toString());
        }
    }
}

