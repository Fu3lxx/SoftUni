package l7associativeArrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p5Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).sorted((n1 ,n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        if (list.size()>3){

            for (int i = 0; i <3 ; i++) {
                System.out.print(list.get(i) + " ");
            }
        }
        else {
            for (Integer word :list){
                System.out.print(word + " ");
            }
        }
    }
}
