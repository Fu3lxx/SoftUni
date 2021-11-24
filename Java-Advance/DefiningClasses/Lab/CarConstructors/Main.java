package DefiningClasses.Lab.CarConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0){
            String [] token = scanner.nextLine().split("\\s+");
            Car car;

            if (token.length == 1){
                car = new Car(token[0]);
            }
            else if (token.length == 2){
                car = new Car(token[0],token[1]);
            }
            else {
                car = new Car(token[0],token[1],Integer.parseInt(token[2]));
            }

            System.out.println(car.carInfo());

        }
    }
}
