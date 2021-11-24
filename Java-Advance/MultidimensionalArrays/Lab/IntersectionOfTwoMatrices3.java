package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char [][] first = readMatrix(rows,cols,scanner);
        char [][] second = readMatrix(rows,cols,scanner);

        char [][] finalM = finalMatrix(first,second);

        printFinalM(finalM);



    }

    private static void printFinalM(char[][] finalM) {
        for (int row = 0; row < finalM.length; row++) {
            for (int col = 0; col <finalM[0].length ; col++) {
                System.out.print(finalM[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] finalMatrix (char[][] firs, char [][] second){
        char [][] finalMatrix = new char[firs.length][];

        for (int row = 0; row < firs.length; row++) {
            finalMatrix[row] = new char[firs[row].length];
            for (int col = 0; col < firs[row].length; col++) {
                finalMatrix[row][col] = firs[row][col] == second[row][col]
                        ? firs[row][col] : '*';
            }
        }
        return finalMatrix;
    }


    private static char[][] readMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] token =scanner.nextLine().split("\\s+");

            for (int j = 0; j < token.length; j++) {
                matrix[i][j] = token[j].charAt(0);
            }
        }
        return matrix;

    }
}
