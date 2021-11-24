package l1moreExe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p1sortNumbers {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(Integer.parseInt(scanner.nextLine()));
        }
        numbers.sort(Collections.reverseOrder());

        numbers.forEach(System.out::println);
    }
}
