package l4labMethods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class p11MathOperators {
    public static double operation (int a , String operation,int b){
        double result=0;

        switch (operation){
            case "*":
                result=a*b;
                break;
            case "+":
                result=a+b;
                break;
            case "-":
                result=a-b;
                break;
            case "/":
                result=a*1.0 / b;
                break;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        String operation = scanner.nextLine();
        int b = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("0.###").format(operation(a, operation, b)));
    }

}
