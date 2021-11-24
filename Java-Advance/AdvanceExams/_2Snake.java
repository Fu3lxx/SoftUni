package AdvanceExams;

import java.util.Scanner;

public class _2Snake {
    static int size;
    static char[][] matrix;
    static int row;
    static int col;
    static int food;
    static boolean outOfField = false;
    static int[] firstL = new int[]{-1,-1};
    static int[] secondL = new int[]{-1,-1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        size = Integer.parseInt(scanner.nextLine());
        matrix = createMatrix(scanner,size);

        while (!outOfField && food < 10){
            String direction = scanner.nextLine();

            switch (direction){
                case "left":
                    move(row,col-1);
                    break;
                case "right":
                    move(row,col+1);
                    break;
                case "up":
                    move(row-1,col);
                    break;
                case "down":
                    move(row+1,col);
                    break;
            }
        }
        if (food >= 10){
            System.out.println("You won! You fed the snake.");
        }
        if (outOfField){
            System.out.println("Game over!");
        }
        System.out.printf("Food eaten: %d\n",food);
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void move(int newRow, int newCol) {
        if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size){
            matrix[row][col] = '.';
            if (matrix[newRow][newCol] == 'B'){
                matrix[newRow][newCol] = '.';
                if (newRow == firstL[0]){
                    newRow = secondL[0];
                    newCol = secondL[1];
                }else {
                    newRow = firstL[0];
                    newCol = firstL[1];
                }
            }
            else if (matrix[newRow][newCol] == '*'){
                food++;
            }
            row = newRow;
            col = newCol;
            matrix[row][col] = 'S';
        }
        else {
            matrix[row][col] = '.';
            outOfField = true;
        }
    }

    private static char[][] createMatrix(Scanner scanner, int size) {
        char [][] temp = new char[size][size];
        for (int r = 0; r < size; r++) {
            String [] symbols = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                char symbol = symbols[c].charAt(0);
                if (symbol == 'S'){
                    row = r;
                    col = c;
                }
                if (symbol == 'B'){
                    if (firstL[0] == -1){
                        firstL[0] = r;
                        firstL[1] = c;
                    }else {
                        secondL[0] = r;
                        secondL[1] = c;
                    }
                }
                temp[r][c] = symbol;
            }
        }
        return temp;
    }
}
