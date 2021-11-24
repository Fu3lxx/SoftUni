package AdvanceExams;

import java.util.Scanner;

public class _2CookingJourney {
    static int row = 0;
    static int col = 0;
    static char[][] matrix;
    static int money = 0;
    static boolean gameOn = true;
    static int [] firstPilar = new int[]{-1,-1};
    static int [] secondPilar = new int[]{-1,-1};
    static int size;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = Integer.parseInt(scanner.nextLine());

        matrix = createMatrix(scanner, size);


        findStart(size);

        while (gameOn) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    move(row - 1, col, matrix);
                    break;
                case "down":
                    move(row + 1, col, matrix);
                    break;
                case "right":
                    move(row, col + 1, matrix);
                    break;
                case "left":
                    move(row, col - 1, matrix);
                    break;
            }
            if (money >= 50) {
                break;
            }
        }

        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        System.out.printf("Money: %d\n", money);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }


    private static void move(int newRow, int newCol, char[][] matrix) {
        if (newCol > size-1 || newCol < 0 || newRow > size-1 || newRow <0){
            matrix[row][col] = '-';
            gameOn = false;
        }
        else {
            char symbol = matrix[newRow][newCol];
            if (Character.isDigit(symbol)){
                money+= Integer.parseInt(String.valueOf(symbol));
                matrix[row][col] = '-';
                matrix[newRow][newCol] = 'S';
                row = newRow;
                col = newCol;
            }
            else if (symbol == 'P'){
                if (row == firstPilar[0]){
                    matrix[row][col] = '-';
                    matrix[newRow][newCol] = '-';
                    row = secondPilar[0];
                    col = secondPilar[1];
                    matrix[row][col] ='S';
                }
                else {
                    matrix[row][col] = '-';
                    matrix[newRow][newCol] = '-';
                    row = firstPilar[0];
                    col = firstPilar[1];
                    matrix[row][col] ='S';
                }
            }
            else {
                matrix[row][col] ='-';
                row = newRow;
                col = newCol;
                matrix[row][col] ='S';
            }
        }
    }

    private static void findStart(int size) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                char symbol = matrix[r][c];
                if (symbol == 'S'){
                    row = r;
                    col = c;
                }
                else if (symbol == 'P'){
                    if (firstPilar[0] == -1){
                        firstPilar[0] = r;
                        firstPilar[1] = c;
                    }
                    else{
                        secondPilar[0] = r;
                        secondPilar[1] = c;
                    }
                }
            }
        }
    }

    private static char[][] createMatrix(Scanner scanner, int size) {
        char [][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String[] elements = scanner.nextLine().split("");
            for (int cow = 0; cow < size; cow++) {
                matrix[row][cow] = elements[cow].charAt(0);
            }
        }
        return matrix;
    }
}
