package l4labMethods;

import java.util.Scanner;

public class calculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = Double.parseDouble(scanner.nextLine());
        double height= Double.parseDouble(scanner.nextLine());
        double area = calculateArea(width,height);
        System.out.printf("%.0f",area);

    }

    public static double calculateArea(double width,double height) {
        return width*height;
    }
}
