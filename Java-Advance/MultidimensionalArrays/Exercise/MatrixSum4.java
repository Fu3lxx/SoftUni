package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixSum4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] arr = reedArr(scanner);
        int rows = arr[0];
        int cols = arr[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int [] temp =  reedArr(scanner);
            matrix[row] = temp;
        }
        //printMatrix(matrix);

        int [][] max3x3Matrix = new int[3][3];
        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row <rows-2 ; row++) {
            for (int col = 0; col < cols-2; col++) {
                int sum = 0;
                sum += matrix[row][col] + matrix[row][col + 1]
                        + matrix[row][col + 2] + matrix[row + 1][col]
                        + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (sum > maxSum){
                    maxSum=sum;
                    max3x3Matrix[0][0] = matrix[row][col];
                    max3x3Matrix[0][1] = matrix[row][col + 1];
                    max3x3Matrix[0][2] = matrix[row][col + 2];
                    max3x3Matrix[1][0] = matrix[row + 1][col];
                    max3x3Matrix[1][1] = matrix[row + 1][col + 1];
                    max3x3Matrix[1][2] = matrix[row + 1][col + 2];
                    max3x3Matrix[2][0] = matrix[row + 2][col];
                    max3x3Matrix[2][1] = matrix[row + 2][col + 1];
                    max3x3Matrix[2][2] = matrix[row + 2][col + 2];
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMatrix(max3x3Matrix);


    }



    private static int[] reedArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void printMatrix(int[][] matrix){
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
