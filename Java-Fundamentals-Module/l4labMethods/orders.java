package l4labMethods;

import java.util.Scanner;

public class orders {
    static void total (String product , int amount ){
        double totalPrice=0.0;

        if (product.equals("coffee")){
            totalPrice = amount*1.5;
            System.out.printf("%.2f",totalPrice);
        }else if (product.equals("water")){
            totalPrice= amount*1.0;
            System.out.printf("%.2f",totalPrice);
        }else if (product.equals("coke")){
            totalPrice= amount*1.40;
            System.out.printf("%.2f",totalPrice);
        }else if (product.equals("snacks")){
            totalPrice= amount*2.0;
            System.out.printf("%.2f",totalPrice);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int amount = Integer.parseInt(scanner.nextLine());

        total(product,amount);
    }

}
