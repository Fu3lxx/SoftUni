package l2exerciseDataTypesandVariables;

import java.util.Scanner;

public class p7WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n= Integer.parseInt(scanner.nextLine());
        int liters=0;

        for (int i = 0; i <n ; i++) {
            int littersPoor = Integer.parseInt(scanner.nextLine());
            if ((littersPoor+liters)<=255){
                liters+=littersPoor;
            }else {
                System.out.println("Insufficient capacity!");
            }
        }

        System.out.println(liters);
    }
}
