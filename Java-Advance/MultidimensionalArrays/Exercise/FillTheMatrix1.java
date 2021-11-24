package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class FillTheMatrix1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String [] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];
        
        int [][] matrix = new int[size][size];
        
        if (pattern.equals("A")){
            fillMatrixA(size, matrix);
            printMatrix(matrix);
        }
        else if (pattern.equals("B")){
            fillMatrixB(size, matrix);
            printMatrix(matrix);
        }
    }

    private static void fillMatrixB(int size, int[][] matrix) {
        int startNum = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0){
                for (int row = 0; row < size; row++) {
                    matrix[row][col]= startNum++;
                }
            }
            else {
                for (int row = size -1; row >= 0 ; row--) {
                    matrix[row][col] = startNum++;
                }

            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixA(int size, int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
    }
}
