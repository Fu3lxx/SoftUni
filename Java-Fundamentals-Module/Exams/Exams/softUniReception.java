package exams;

import java.util.Scanner;

public class softUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeePower=0;
        for (int i = 1; i <=3 ; i++) {
            employeePower+=Integer.parseInt(scanner.nextLine());
        }
        int students=Integer.parseInt(scanner.nextLine());
        int hour=0;

        while (students>0){
            students=students-employeePower;
            hour++;
            if (hour%4==0){
                hour++;
                continue;
            }


        }
        System.out.printf("Time needed: %dh.",hour);
    }
}
