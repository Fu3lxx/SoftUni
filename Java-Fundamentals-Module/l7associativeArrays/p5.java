package l7associativeArrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p5 {
    public static void main(String[] args) {
        Scanner scanner  =new Scanner(System.in);
        List <Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).sorted((n1,n2) ->n2.compareTo(n1)).limit(3).collect(Collectors.toList());

        for (Integer num : list){
            System.out.print(num + " ");
        }
    }
}
