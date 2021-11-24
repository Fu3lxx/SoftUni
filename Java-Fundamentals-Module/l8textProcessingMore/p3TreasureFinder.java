package l8textProcessingMore;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class p3TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        while (!input.equals("find")){

            for (int i = 0; i <input.length() ; i++) {

            }

            input= scanner.nextLine();
        }

    }
}
