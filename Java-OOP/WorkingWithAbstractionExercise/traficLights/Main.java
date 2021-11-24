package WorkingWithAbstractionExercise.traficLights;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] lightsColor = scanner.nextLine().split("\\s+");
        List<Light> lights = new ArrayList<>();
        int times = Integer.parseInt(scanner.nextLine());

        for (String color:lightsColor){
            Light light = new Light(Color.valueOf(color));
            lights.add(light);
        }

        for (int i = 0; i < times; i++) {
            lights.forEach(Light::changeColor);
            lights.forEach(color -> System.out.print(color.getColor() + " "));
            System.out.println();
        }
    }
}
