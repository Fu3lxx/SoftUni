package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] rAndC = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = rAndC[0];
        int cols = rAndC[1];

        String [][] matrix = new String[rows][cols];
        fillMatrix(scanner, rows, matrix);

        String input = scanner.nextLine();
        while (!input.equals("END")){

            if (!validateCommand(input,rows,cols)){
                System.out.println("Invalid input!");
            }
            else {
                executeCommand(matrix, input);
                printMatrix(matrix);
            }


            input= scanner.nextLine();
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] executeCommand(String[][] matrix, String input) {
        String [] arr = input.split("\\s+");
        String commandName = arr[0];
        int rowFirst = Integer.parseInt(arr[1]);
        int colFirst = Integer.parseInt(arr[2]);
        int rowSecond = Integer.parseInt(arr[3]);
        int colSecond = Integer.parseInt(arr[4]);

        String element1 = matrix[rowFirst][colFirst];
        String element2 = matrix[rowSecond][colSecond];

        matrix[rowFirst][colFirst] = element2;
        matrix[rowSecond][colSecond] = element1;
        return matrix;


        }


    private static boolean validateCommand(String input, int rows, int cols) {
        String [] arr = input.split("\\s+");
        String commandName = arr[0];
        if (!commandName.equals("swap")){
            return false;
        }
        if (arr.length != 5){
            return false;
        }
        int rowFirst = Integer.parseInt(arr[1]);
        int colFirst = Integer.parseInt(arr[2]);
        int rowSecond = Integer.parseInt(arr[3]);
        int colSecond = Integer.parseInt(arr[4]);

        if (rowFirst > rows || colFirst > cols || rowSecond > rows || colSecond > cols){
            return false;
        }
        else if (rowFirst < 0 || colFirst < 0 || rowSecond < 0 || colSecond < 0){
            return false;
        }
        else {
            return true;
        }

    }

    private static void fillMatrix(Scanner scanner, int rows, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
           String [] arr = scanner.nextLine().split(" ");
           matrix[row] = arr;
        }
    }
}
