package l4labMethods;

import java.util.Scanner;

public class calculations {
    public static int subtract (int first, int second){
        int sum = first-second;
        return sum;
    }
    public  static int divide (int first , int second){
        int sum= first/second;
        return sum;
    }
    public static int add(int first , int second){
        int sum= first + second;
        return sum;
    }
    public static int multiply(int first, int second){
        int sum=first*second;
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String calculation= scanner.nextLine();
        int first=Integer.parseInt(scanner.nextLine());
        int second=Integer.parseInt(scanner.nextLine());

        if (calculation.equals("subtract")){
            System.out.println(subtract(first,second));
        }
        else if (calculation.equals("divide")){
            System.out.println(divide(first,second));
        }
        else if (calculation.equals("add")){
            System.out.println(add(first,second));
        }
        else if (calculation.equals("multiply")){
            System.out.println(multiply(first,second));
        }
    }




}
