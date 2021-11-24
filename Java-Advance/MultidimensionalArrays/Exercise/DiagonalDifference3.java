package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int[size][size];

        fillMatrix(scanner, size, matrix);

        int sumPrimary = getPrimarySum(matrix);
        int sumSecondary = getSecondarySum(matrix);

        System.out.println(Math.abs(sumPrimary-sumSecondary));


    }

    private static int getSecondarySum(int[][] matrix) {
        int sum = 0;
        for (int col = 0; col <matrix.length ; col++) {
            for (int row = matrix.length - 1; row >=0 ; row--) {
                sum += matrix[row][col];
                col++;
            }
        }
        return sum;
    }

    private static int getPrimarySum(int[][] matrix) {
        int sum =0;
        for (int col = 0; col < matrix.length ; col++) {
            sum += matrix[col][col];
        }
        return sum;
    }

    private static void fillMatrix(Scanner scanner, int size, int[][] matrix) {
        for (int row = 0; row < size; row++) {
            int [] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row]= arr;
        }
    }
}
