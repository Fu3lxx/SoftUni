package oldProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class sinoTheWalker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> list = Arrays.stream(scanner.nextLine().split(":")).map(Integer::parseInt).collect(Collectors.toList());

        int stepsToHome =Integer.parseInt(scanner.nextLine());
        int secondsForOneStep =Integer.parseInt(scanner.nextLine());

        int secondsToGetHome = stepsToHome * secondsForOneStep;



        int seconds = list.get(2);
        int minutes = list.get(1);
        int hours = list.get(0);

        int minutesToAdd =secondsToGetHome/60;
        int secondsToAdd=secondsToGetHome - (minutesToAdd*60);
        int hoursToAdd =minutesToAdd/60;
        minutesToAdd= minutesToAdd - (hoursToAdd*60);

        seconds+=secondsToAdd;
        if (seconds>=60){
            minutes++;
            seconds-=60;
        }
        minutes+=minutesToAdd;
        if (minutes>=60){
            hours++;
            minutes-=60;
        }
        hours+=hoursToAdd;
        if (hours>23){
            hours-=24;
        }



        System.out.printf("Time Arrival: %02d:%02d:%02d",hours,minutes,seconds);
    }
}
