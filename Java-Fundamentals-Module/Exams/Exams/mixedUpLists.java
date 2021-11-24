package exams;

import java.util.*;
import java.util.stream.Collectors;

public class mixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList =  Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> borders = new ArrayList<>();
        List<Integer> finalList = new ArrayList<>();

        if (firstList.size()>secondList.size()){
            borders.add(firstList.get(firstList.size()-2));
            borders.add(firstList.get(firstList.size()-1));
            firstList.remove(firstList.size()-1);
            firstList.remove(firstList.size()-1);
        }
        else {
            borders.add(secondList.get(secondList.size()-2));
            borders.add(secondList.get(secondList.size()-1));
            secondList.remove(secondList.size()-1);
            secondList.remove(secondList.size()-1);
        }

        Collections.reverse(secondList);
        for (int i = 0; i <firstList.size() ; i++) {
            finalList.add(firstList.get(i));
            finalList.add(secondList.get(i));
        }

        Collections.sort(borders);
        List <Integer> finalFinal = new ArrayList<>();
        for (int i = 0; i <finalList.size() ; i++) {
            int currentNumber = finalList.get(i);
            int minBorder = borders.get(0);
            int maxBorder =borders.get(1);
            if (currentNumber>minBorder && currentNumber<maxBorder){
                finalFinal.add(currentNumber);
            }
        }

        Collections.sort(finalFinal);
        for (int i = 0; i <finalFinal.size() ; i++) {
            System.out.print(finalFinal.get(i) + " ");
        }

    }
}
