package l1lLabBasicSyntaxConditionStatementsAndLoops;

import java.util.Scanner;

public class p7TheatrePromotions {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String day= scanner.nextLine();
        int age=Integer.parseInt(scanner.nextLine());
        int price=-1;

        if ("Weekday".equals(day)) {
            if ((0 <= age && age <= 18) || (64 < age && age <= 122)) {
                price = 12;
            }
            else if (18<age&&age<=64){
                price = 18;
            }
        } else if ("Weekend".equals(day)) {
            if ((0 <= age && age <= 18) || (64 < age && age <= 122)) {
                price = 15;
            } else if (18<age&&age<=64){
                price = 20;
            }
        } else if ("Holiday".equals(day)) {
            if (0 <= age && age <= 18) {
                price = 5;
            }
            else if (18 < age && age <= 64) {
                price = 12;
            }
            else if (64 < age && age <= 122) {
                price = 10;
            }
        }
        if (price==-1){
            System.out.println("Error!");
        }
        else {
            System.out.println(price+"$");
        }
    }
}
