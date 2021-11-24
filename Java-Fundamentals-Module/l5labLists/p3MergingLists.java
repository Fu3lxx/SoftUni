package l5labLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p3MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> finalList = new ArrayList<>();

        if (firstList.size() >= secondList.size()) {
            for (int i = 0; i < firstList.size(); i++) {
                finalList.add(firstList.get(i));
                if (secondList.size() > i) {
                    finalList.add(secondList.get(i));
                }
            }
        } else {
            for (int i = 0; i < secondList.size(); i++) {
                if (firstList.size() > i) {

                    finalList.add(firstList.get(i));
                }
                finalList.add(secondList.get(i));

            }
        }
        for (int i = 0; i <finalList.size() ; i++) {
            System.out.print(finalList.get(i)+ " ");
        }
    }
}
