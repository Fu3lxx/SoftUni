package AdvanceExams;

import java.util.Scanner;

public class _2PresentDelivery {
    static int row;
    static int col;
    static char[][] matrix;
    static int deliveredPresents = 0;
    static int goodKids = 0;
    static int size;
    static boolean outOfField = false;
    static int presentsLeft;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        presentsLeft = Integer.parseInt(scanner.nextLine());
        size = Integer.parseInt(scanner.nextLine());
        matrix = createMatrix(scanner,size);
        int totalGoodKids = goodKids;

        while (goodKids > 0 || presentsLeft <= 0){
            String command = scanner.nextLine();

            switch (command){
                case "up":
                    move(row-1,col);
                    break;
                case "down":
                    move(row+1,col);
                    break;
                case "right":
                    move(row,col+1);
                    break;
                case "left":
                    move(row,col-1);
                    break;

            }
            if (outOfField || command.equals("Christmas morning") || presentsLeft <= 0){
                break;
            }
        }

        if (outOfField || presentsLeft <= 0){
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(matrix);
        if (goodKids <= 0){
            System.out.printf("Good job, Santa! %d happy nice kid/s.\n",totalGoodKids);
        }
        else {
            System.out.printf("No presents for %d nice kid/s.\n",goodKids);
        }

    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static void move(int newRow, int newCol) {
        if (newRow < 0 || newRow > size-1 || newCol < 0 || newCol > size-1){
            outOfField = true;

        }
        else {
            char symbol = matrix[newRow][newCol];
            matrix[row][col] = '-';
            if (symbol == 'V'){
                goodKids--;
                presentsLeft--;
            }
            else if (symbol == 'X'){

            }
            else if (symbol == 'C'){
                //up
                if (matrix[newRow-1][newCol] == 'X' || matrix[newRow-1][newCol] == 'V' && presentsLeft > 0){
                    matrix[newRow-1][newCol] = '-';
                    presentsLeft--;
                    if (matrix[newRow-1][newCol] == 'V'){
                        deliveredPresents ++;
                        goodKids--;
                    }
                }
                //down
                if (matrix[newRow+1][newCol] == 'X' || matrix[newRow+1][newCol] == 'V' && presentsLeft > 0){
                    matrix[newRow+1][newCol] = '-';
                    presentsLeft--;
                    if (matrix[newRow+1][newCol] == 'V'){
                        deliveredPresents ++;
                        goodKids--;
                    }
                }
                //right
                if (matrix[newRow][newCol+1] == 'X' || matrix[newRow][newCol+1] == 'V' && presentsLeft > 0){
                    matrix[newRow][newCol+1] = '-';
                    presentsLeft--;
                    if (matrix[newRow][newCol+1] == 'V'){
                        deliveredPresents ++;
                        goodKids--;
                    }
                }
                if (matrix[newRow][newCol-1] == 'X' || matrix[newRow][newCol-1] == 'V' && presentsLeft > 0){
                    matrix[newRow][newCol-1] = '-';
                    presentsLeft--;
                    if (matrix[newRow][newCol-1] == 'V'){
                        deliveredPresents ++;
                        goodKids--;
                    }
                }
            }
            matrix [row][col] = '-';
            matrix[newRow][newCol] = 'S';
            row = newRow;
            col = newCol;
        }
    }

    private static char[][] createMatrix(Scanner scanner, int size) {
        char[][] temp = new char[size][size];
        for (int r = 0; r < size; r++) {
            String [] arr = scanner.nextLine().split("\\s+");
            for (int c = 0; c < size; c++) {
                char symbol = arr[c].charAt(0);
                temp[r][c] = symbol;
                if (symbol == 'S'){
                    row = r;
                    col = c;
                }
                if (symbol == 'V'){
                    goodKids++;
                }
            }
        }
        return temp;
    }
}
