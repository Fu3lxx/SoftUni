package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class MatrixOfPalindromes2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String [][] matrix = new String[rows][cols];

        char start = 'a';
        for (int r = 0; r <rows ; r++) {
            for (int c = 0; c < cols; c++) {
                String palindrome = "" + start + (char) (start + c) + start;
                matrix [r][c] = palindrome;
            }
            start = (char)(start+1);
        }

        printMatrix(rows, cols, matrix);
    }

    private static void printMatrix(int rows, int cols, String[][] matrix) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
