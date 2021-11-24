package SetsAndMaps.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        TreeSet<String> set = new TreeSet<>();

        for (int i = 1; i <=count ; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            set.addAll(Arrays.asList(elements));
        }

        for (var element: set){
            System.out.print(element + " ");
        }
    }
}
