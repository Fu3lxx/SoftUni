package l3exerciseArrays;

import java.util.Scanner;

public class p1Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum =0;

        int[] trains = new int[n];
        for (int i = 0; i <trains.length; i++) {
            trains[i] = Integer.parseInt(scanner.nextLine());
            sum+=trains[i];
        }
        for (int i = 0; i < trains.length; i++) {
            System.out.print(trains[i]+" ");
        }
        System.out.println();
        System.out.print(sum);

    }
}
