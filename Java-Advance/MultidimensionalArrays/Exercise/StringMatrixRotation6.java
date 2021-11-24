package MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotation = scanner.nextLine();
        int angle = Integer.parseInt(rotation.split("[()]+")[1]) % 360;

        List<String> matrixSize = new ArrayList<>();

        String input = scanner.nextLine();
        int maxLength = Integer.MIN_VALUE;
        while (!input.equals("END")){
            matrixSize.add(input);
            if (input.length() > maxLength){
                maxLength = input.length();
            }

            input= scanner.nextLine();
        }
        int rows = matrixSize.size();
        int cols = maxLength;

        char [][] matrix = new char[rows][cols];
        for (int i = 0; i < rows ; i++) {
            String current = matrixSize.get(i);
            char[] ch = new char[cols];

            for (int j = 0; j <cols ; j++) {
                if (j > current.length()-1){
                    ch[j] = ' ';
                }
                else {
                    ch[j] = current.charAt(j);
                }
            }
            matrix[i] = ch;
        }
        rotate(angle, rows, cols, matrix);


    }

    private static void rotate(int angleRotation, int rows, int cols, char[][] matrix) {
        if (angleRotation == 90){
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0 ; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else if (angleRotation == 180){
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else if (angleRotation == 270){
            for (int col = cols - 1; col >= 0 ; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }


    }
}
