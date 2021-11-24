package midExam;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double qFood = Double.parseDouble(scanner.nextLine()) * 1000;
        double qHay = Double.parseDouble(scanner.nextLine()) * 1000;
        double qCover = Double.parseDouble(scanner.nextLine()) * 1000;
        double guineaW = Double.parseDouble(scanner.nextLine()) * 1000;

        boolean haveFood =true;

        int day = 0;

        while (day!=30){

            day++;
            qFood -= 300;
            if (day %2 ==0){
                qHay -= 0.05 * qFood;

            }
            if (day % 3 == 0){
                qCover -= (guineaW/3);
            }
            if (qFood <= 0 || qHay <= 0 || qCover <=0){
                haveFood = false;
                break;
            }

        }

        if (haveFood){
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",qFood/1000 , qHay/1000, qCover/1000);
        }
        else {
            System.out.println("Merry must go to the pet store!");
        }

    }
}
