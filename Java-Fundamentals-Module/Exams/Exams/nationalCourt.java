package exams;

import java.util.Scanner;

public class nationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeesPower=0;

        for (int i = 1; i <= 3; i++) {
            employeesPower+=Integer.parseInt(scanner.nextLine());
        }
        int peopleToAnswer=Integer.parseInt(scanner.nextLine());

        int hours=0;
        while (peopleToAnswer>0){

            peopleToAnswer-=employeesPower;
            hours++;
            if (hours>0 &&hours%4==0){
                hours++;

            }
        }
        System.out.printf("Time needed: %dh.",hours);

    }
}
