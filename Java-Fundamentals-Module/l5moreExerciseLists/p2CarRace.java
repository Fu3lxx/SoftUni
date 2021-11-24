package l5moreExerciseLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p2CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> list = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
        List<Double> rightRacer=new ArrayList<>();
        List<Double> leftRacer=new ArrayList<>();

        for (int i = 0; i <list.size()/2; i++) {
            rightRacer.add(list.get(i));
        }
        for (int i = list.size()/2+1; i <list.size() ; i++) {
            leftRacer.add(list.get(i));
        }
        double sumRight=0;
        double sumLeft=0;

        for (int i = leftRacer.size()-1; i >=0 ; i--) {
            if (leftRacer.get(i)==0){
                sumLeft*=0.8;
            }
            sumLeft+=leftRacer.get(i);
        }
        for (int i = 0; i <rightRacer.size() ; i++) {
            if (rightRacer.get(i)==0){
                sumRight*=0.8;
            }
            sumRight+=rightRacer.get(i);
        }
        if (sumRight<sumLeft){
            System.out.printf("The winner is left with total time: %.1f",sumRight);
        }
        else {
            System.out.printf("The winner is right with total time: %.1f",sumLeft);
        }

    }
}
