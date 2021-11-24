package l5labLists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p2GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        boolean isOdd = true;
        if (list.size() % 2 == 0) {
            isOdd = false;
        }
        if (isOdd) {
            for (int i = 0; i < list.size() / 2; i++) {
                int first = list.get(i);
                int last = list.get(list.size() - 1);

                list.remove(list.size() - 1);
                list.set(i, first + last);
            }
        } else {
            for (int i = 0; i < list.size() / 2 + 1; i++) {
                int first = list.get(i);
                int last = list.get(list.size() - 1);

                list.remove(list.size() - 1);
                list.set(i, first + last);
            }
        }
        for (int i = 0; i <list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
