package exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class drumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        String list = scanner.nextLine();
        List <Integer> originalList = Arrays.stream(list.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List <Integer> secondaryList = Arrays.stream(list.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Hit it again, Gabsy!")){
            int damage = Integer.parseInt(input);

            for (int i = 0; i <secondaryList.size() ; i++) {
                int currentHealth = secondaryList.get(i);
                secondaryList.set(i,currentHealth-damage);
            }

            for (int i = 0; i <secondaryList.size() ; i++) {
                if (secondaryList.get(i) <= 0){
                    int priceToRepair = originalList.get(i) * 3;
                    int initialQuality = originalList.get(i);
                    if (savings>=priceToRepair){
                        savings-=priceToRepair;
                        secondaryList.set(i,initialQuality);
                    }
                    else {
                        secondaryList.remove(i);
                        originalList.remove(i);
                    }
                }
            }

            input= scanner.nextLine();
        }
        for (int i = 0; i <secondaryList.size() ; i++) {
            System.out.print(secondaryList.get(i) + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.",savings);
    }
}
