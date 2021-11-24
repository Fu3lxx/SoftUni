package exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class theLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleOnQueue = Integer.parseInt(scanner.nextLine());
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        boolean liftIsFull = false;

        while (peopleOnQueue > 0) {
            boolean anySpace = false;
            if (isThereAnySpace(list)){
                anySpace=true;
            }
            if (!anySpace) {
                liftIsFull = true;
                break;
            }
            for (int i = 0; i < list.size(); i++) {
                int currentPeopleInLift = list.get(i);
                if (list.get(i) < 4) {
                    list.set(i, currentPeopleInLift + 1);
                    peopleOnQueue--;
                    break;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {


        }
        if (!isThereAnySpace(list)){
            liftIsFull=true;
        }
        if (!liftIsFull) {
            System.out.println("The lift has empty spots!");
            printList(list);
        } else if (liftIsFull && peopleOnQueue > 0) {
            System.out.println("There isn't enough space! " + peopleOnQueue + " people in a queue!");
            printList(list);
        } else {
            printList(list);
        }
    }

    public static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static boolean isThereAnySpace(List<Integer> list) {
        boolean anySpace = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 4) {
                anySpace = true;
                break;
            }
        }
        if (anySpace) {
            return true;
        } else {
            return false;
        }


    }
}
