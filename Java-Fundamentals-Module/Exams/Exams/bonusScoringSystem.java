package exams;

import java.util.Scanner;

public class bonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in);

        int amountStudents= Integer.parseInt(scanner.nextLine());
        int amountLectures = Integer.parseInt(scanner.nextLine());
        int initialBonus =Integer.parseInt(scanner.nextLine());

        double maxBonus=0;
        int attendedLectures=0;

        for (int i = 0; i <amountStudents ; i++) {
            int attendance = Integer.parseInt(scanner.nextLine());

            double calculation = attendance*1.0 / amountLectures * (5+ initialBonus);
            if (calculation>maxBonus){
                maxBonus=calculation;
                attendedLectures=attendance;
            }
        }
        System.out.printf("Max Bonus: %.0f.\nThe student has attended %d lectures.",Math.ceil(maxBonus),attendedLectures);
    }
}
