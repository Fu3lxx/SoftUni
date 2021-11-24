package SetsAndMaps.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsAndMapsAdvanced1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> set = new LinkedHashSet<>();
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <=count ; i++) {
            String username = scanner.nextLine();
            set.add(username);
        }

        set.forEach(System.out::println);
    }
}
