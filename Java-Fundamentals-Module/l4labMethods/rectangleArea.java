package l4labMethods;

import java.util.Scanner;

public class rectangleArea {
    public static double getRectangleArea (double width,double height ){
        return width*height;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = Double.parseDouble(scanner.nextLine());
        double height= Double.parseDouble(scanner.nextLine());
        double area = getRectangleArea(width,height);
        System.out.printf("%.0f",area);
    }

}
