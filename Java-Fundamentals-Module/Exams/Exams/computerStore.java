package exams;

import java.util.Scanner;

public class computerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean special =false;
        String input = scanner.nextLine();
        double totalAmount=0;
        while (true){
            if (input.equals("special") || input.equals("regular")){
                if (input.equals("special")){
                    special=true;
                }
                break;
            }
            double currentSum =Double.parseDouble(input);
            if (currentSum<0){
                System.out.println("Invalid price!");
                input= scanner.nextLine();
                continue;
            }
            totalAmount+=currentSum;
            input= scanner.nextLine();
        }
        double tax = 0.2*totalAmount;
        double totalAmountWithTax=totalAmount + tax;
        if (special){
            totalAmountWithTax=totalAmountWithTax -(totalAmountWithTax*0.1);
        }

        if (totalAmountWithTax>0){
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$\n",totalAmount);
            System.out.printf("Taxes: %.2f$\n",tax);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$",totalAmountWithTax);
        }
        else {
            System.out.println("Invalid order!");
        }


    }
}
