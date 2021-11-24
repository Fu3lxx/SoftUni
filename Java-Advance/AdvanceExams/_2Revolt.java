package AdvanceExams;

import java.util.Scanner;

public class _2Revolt {
    static int row;
    static int col;
    static int size;
    static char[][] matrix;
    static boolean finishReached = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        size = Integer.parseInt(scanner.nextLine());
        int commands = Integer.parseInt(scanner.nextLine());
        matrix = createMatrix(scanner,size);

        for (int i = 0; i < commands; i++) {
            String command = scanner.nextLine();

            switch (command){
                case "up":
                    move(row-1,col,command);
                    break;
                case "down":
                    move(row+1,col,command);
                    break;
                case "right":
                    move(row,col+1,command);
                    break;
                case "left":
                    move(row,col-1,command);
                    break;
            }
            if (finishReached){
                break;
            }
        }
        if (finishReached){
            System.out.println("Player won!");
        }else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);



    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void move(int newRow, int newCol, String command) {
        matrix[row][col] = '-';
        if (isOutOfB(newRow, newCol)){
            if (newRow <0){
                newRow = size-1;
            }else if (newRow > size-1){
                newRow = 0;
            }else if (newCol < 0){
                newCol = size-1;
            }else {
                newCol = 0;
            }
        }

        char symbol = matrix[newRow][newCol];
        if (symbol == 'B'){
            if (command.equals("up")){
                newRow -= 1;
            }else if (command.equals("down")){
                newRow += 1;
            }else if (command.equals("right")){
                newCol += 1;
            }else if (command.equals("left")){
                newCol -=1;
            }

            if (isOutOfB(newRow, newCol)){
                if (newRow <0){
                    newRow = size-1;
                }else if (newRow > size-1){
                    newRow = 0;
                }else if (newCol < 0){
                    newCol = size-1;
                }else {
                    newCol = 0;
                }
            }
            char afterBonusSymbol = matrix[newRow][newCol];
            if (afterBonusSymbol == 'F'){
                matrix[newRow][newCol] = 'f';
                finishReached = true;
            }
            row = newRow;
            col =newCol;
        }
        symbol = matrix[newRow][newCol];
        if (symbol == 'F'){
            finishReached = true;
            matrix[newRow][newCol] = 'f';
        }
        else if (symbol == 'T'){

        }
        else {
            row = newRow;
            col = newCol;
            matrix[row][col] = 'f';
        }


        }

    private static void bonusMove(int newRow, int newCol, String command) {
        if (command.equals("up")){
            newRow -= 1;
        }else if (command.equals("down")){
            newRow += 1;
        }else if (command.equals("right")){
            newCol += 1;
        }else if (command.equals("left")){
            newCol -=1;
        }
    }


    private static boolean isOutOfB(int newRow, int newCol) {
        return newRow < 0 || newRow > size - 1 || newCol < 0 || newCol > size - 1;
    }


    private static char[][] createMatrix(Scanner scanner, int size) {
        char[][] m = new char[size][size];
        for (int r = 0; r < size; r++) {
            String [] data = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                char symbol = data[c].charAt(0);
                m[r][c] =symbol;
                if (symbol == 'f'){
                    row = r;
                    col = c;
                }
            }
        }
        return m;
    }
}
