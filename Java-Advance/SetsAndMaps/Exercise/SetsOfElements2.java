package SetsAndMaps.Exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];

        LinkedHashSet<Integer> nSet = new LinkedHashSet<>(n);
        LinkedHashSet<Integer> mSet = new LinkedHashSet<>(m);

        for (int i = 0; i <n ; i++) {
            nSet.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i <m ; i++) {
            mSet.add(Integer.parseInt(scanner.nextLine()));
        }

        nSet.retainAll(mSet);

        nSet.forEach(integer -> System.out.print(integer + " "));
    }
}
