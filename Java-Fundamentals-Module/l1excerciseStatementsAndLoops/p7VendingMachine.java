package l1excerciseStatementsAndLoops;

import java.util.Scanner;

public class p7VendingMachine {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String n= scanner.nextLine();

        double nuts=2.0;
        double water=0.7;
        double crisps=1.5;
        double soda=0.8;
        double coke=1.0;
        double totalMoney=0;

        while (!n.equals("Start")){
            double coin=Double.parseDouble(n);
            if (coin==2){
                totalMoney+=2;
            }else if (coin==1){
                totalMoney+=1;
            }else if (coin==0.5){
                totalMoney+=0.5;
            }else if (coin==0.2){
                totalMoney+=0.2;
            }else if (coin==0.1){
                totalMoney+=0.1;
            }else {
                System.out.printf("Cannot accept %.2f %n",coin);
            }
            n= scanner.nextLine();
        }
        n= scanner.nextLine();
        while (!n.equals("End")){
            if (n.equals("Nuts")){
                if (totalMoney-nuts>=0){
                    System.out.println("Purchased Nuts");
                    totalMoney-=nuts;
                }else {
                    System.out.println("Sorry, not enough money");

                }
            }
            else if (n.equals("Water")){
                if (totalMoney-water>=0){
                    System.out.println("Purchased Water");
                    totalMoney-=water;
                }else {
                    System.out.println("Sorry, not enough money");

                }
            }
            else if (n.equals("Crisps")){
                if (totalMoney-crisps>=0){
                    System.out.println("Purchased Crisps");
                    totalMoney-=crisps;
                }else {
                    System.out.println("Sorry, not enough money");

                }
            }
            else if (n.equals("Soda")){
                if (totalMoney-soda>=0){
                    System.out.println("Purchased Soda");
                    totalMoney-=soda;
                }else {
                    System.out.println("Sorry, not enough money");

                }
            }
            else if (n.equals("Coke")){
                if (totalMoney-coke>=0){
                    System.out.println("Purchased Coke");
                    totalMoney-=coke;
                }else {
                    System.out.println("Sorry, not enough money");

                }
            }else {
                System.out.println("Invalid product");
            }

            n= scanner.nextLine();
        }
        System.out.printf("Change: %.2f",totalMoney);
    }
}
