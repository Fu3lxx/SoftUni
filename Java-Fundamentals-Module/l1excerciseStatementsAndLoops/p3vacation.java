package l1excerciseStatementsAndLoops;

import java.util.Scanner;

public class p3vacation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int groupNum=Integer.parseInt(scanner.nextLine());
        String typeOfGroup= scanner.nextLine();
        String dayOfWeek= scanner.nextLine();

        double price =0;

        switch (dayOfWeek){
            case "Friday":
                if (typeOfGroup.equals("Students")){
                    price=8.45;
                }else if (typeOfGroup.equals("Business")){
                    price=10.90;
                }else if (typeOfGroup.equals("Regular")){
                    price=15;
                }break;
            case "Saturday":
                if (typeOfGroup.equals("Students")){
                    price=9.80;
                }else if (typeOfGroup.equals("Business")){
                    price=15.60;
                }else if (typeOfGroup.equals("Regular")){
                    price=20;
                }break;
            case "Sunday":
                if (typeOfGroup.equals("Students")){
                    price=10.46;
                }else if (typeOfGroup.equals("Business")){
                    price=16;
                }else if (typeOfGroup.equals("Regular")){
                    price=22.50;
                }break;
        }
        double totalP=price*groupNum*1.0;

        if (typeOfGroup.equals("Students")){
            if (groupNum>=30){
                totalP*=0.85;
            }
        }
        if (typeOfGroup.equals("Business")){
            if (groupNum>=100){
                totalP=totalP-(10*price);
            }
        }
        if (typeOfGroup.equals("Regular")){
            if (groupNum>=10&&groupNum<=20){
                totalP*=0.95;
            }
        }
        System.out.printf("Total price: %.2f",totalP);
    }
}
