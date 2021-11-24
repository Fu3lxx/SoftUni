package l1excerciseStatementsAndLoops;

import java.util.Scanner;

public class p9PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double budget =Double.parseDouble(scanner.nextLine());
        int students=Integer.parseInt(scanner.nextLine());
        double lightSabersPrise=Double.parseDouble(scanner.nextLine());
        double robesPrice=Double.parseDouble(scanner.nextLine());
        double betsPrise=Double.parseDouble(scanner.nextLine());

        double moneyForSabres=lightSabersPrise*(Math.ceil(students*1.1));
        double moneyForRobes=robesPrice*students;
        int freeBelts= students/6;
        double moneyForBelts=betsPrise*(students-freeBelts);

        double allMoneyNeeded=moneyForSabres+moneyForRobes+moneyForBelts;

        if (allMoneyNeeded<=budget){
            System.out.printf("The money is enough - it would cost %.2flv.",allMoneyNeeded);
        }else {
            System.out.printf("George Lucas will need %.2flv more.",allMoneyNeeded-budget);
        }

    }
}
