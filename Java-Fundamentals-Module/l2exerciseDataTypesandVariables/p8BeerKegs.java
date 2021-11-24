package l2exerciseDataTypesandVariables;

import java.util.Scanner;

public class p8BeerKegs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        double maxVolume= Double.MIN_VALUE;
        String maxName="";

        for (int i = 0; i < n; i++) {
            String name= scanner.nextLine();
            double radius=Double.parseDouble(scanner.nextLine());
            double height =Double.parseDouble(scanner.nextLine());

            double volume=Math.PI * Math.pow(radius,2) *height;

            if (volume>maxVolume){
                maxVolume=volume;
                maxName=name;
            }
        }
        System.out.printf("%s",maxName);
    }
}
