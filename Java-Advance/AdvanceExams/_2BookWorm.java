package AdvanceExams;

import java.util.Scanner;

public class _2BookWorm {
    static char[][] matrix;
    static int row;
    static int col;
    static StringBuilder string;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        string = new StringBuilder().append(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        matrix = createMatrix(size,scanner);

        String command = scanner.nextLine();
        while (!command.equals("end")){
            switch (command){
                case "up":
                    move(row-1,col,size);
                    break;
                case "down":
                    move(row+1,col,size);
                    break;
                case "right":
                    move(row,col+1,size);
                    break;
                case "left":
                    move(row,col-1,size);
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println(string.toString());
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

    private static void move(int newRow, int newCol,int size) {

        if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size){
            matrix[row][col] = '-';
            char symbol = matrix[newRow][newCol];
            if (symbol != '-'){// there is possibility for other symbols
                string.append(symbol);
            }
            row = newRow;
            col = newCol;
            matrix[row][col] = 'P';
        }
        else {
            //out
            if (string.length() > 0){
                string.deleteCharAt(string.length()-1);
            }
        }
    }

    private static char[][] createMatrix(int size, Scanner scanner) {
        char[][] tempM = new char[size][size];
        for (int r = 0; r < size; r++) {
            String[] arr = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                char symbol = arr[c].charAt(0);
                tempM [r][c] = symbol;
                if (symbol == 'P'){
                    row = r;
                    col = c;
                }
            }
        }
        return tempM;
    }
}
