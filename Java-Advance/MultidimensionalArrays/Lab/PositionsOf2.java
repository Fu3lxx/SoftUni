package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] cAndR = reedArray(scanner);
        int rows = cAndR[0];
        int cols = cAndR[1];

        int [][] matrix = new int[rows][cols];

        for (int i = 0; i < rows ; i++) {
            matrix[i] = reedArray(scanner);
        }
        int number = Integer.parseInt(scanner.nextLine());
        boolean found = false;

        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (matrix[i][j] == number){
                    System.out.println(i + " " + j);
                    found=true;
                }
            }
        }
        if (!found){
            System.out.println("not found");
        }
    }

    private static int[] reedArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
