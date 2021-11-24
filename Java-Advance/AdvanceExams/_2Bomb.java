package AdvanceExams;

import java.io.IOException;
import java.util.Scanner;


public class _2Bomb {
    public static boolean isOver = false;
    public static int row = 0;
    public static int cow = 0;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        String [] commands = scanner.nextLine().split(",");
        char [][] matrix = createMatrix(matrixSize,scanner);


        int bombs = 0;
        for (int r = 0; r < matrixSize; r++) {
            for (int c = 0; c < matrixSize; c++) {
                if (matrix[r][c] == 's'){
                    row = r;
                    cow = c;
                }
                if (matrix[r][c] == 'B'){
                    bombs++;
                }
            }
        }

        for (int i = 0; i <commands.length ; i++) {
            String command = commands[i];
            char currentSymbol = matrix[row][cow];

            if (command.equals("up")){
                if (isInBounds(row-1,cow,matrix)){
                    row --;
                    bombs = move(matrix, row, cow, bombs);
                }
            }
            else if (command.equals("down")){
                if (isInBounds(row+1,cow,matrix)){
                    row++;
                    bombs = move(matrix, row, cow, bombs);
                }
            }
            else if (command.equals("right")){
                if (isInBounds(row,cow+1,matrix)){
                    cow++;
                    bombs = move(matrix, row, cow, bombs);
                }
            }
            else if (command.equals("left")){
                if (isInBounds(row,cow-1,matrix)){
                    cow--;
                    bombs = move(matrix, row, cow, bombs);
                }
            }
            if (isOver || bombs <= 0){
                break;
            }
        }
        if (!isOver && bombs > 0){
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",bombs,row,cow);
        }
        else if (bombs <= 0){
            System.out.println("Congratulations! You found all bombs!");
        }
        else if (isOver){
            System.out.println("END! " + bombs + " bombs left on the field");
        }


    }

    private static int move(char[][] matrix, int row, int cow, int bombs) {
        char symbol = matrix[row][cow];
        if (symbol == 'B'){
            matrix[row][cow] = '+';
            bombs--;
            System.out.println("You found a bomb!");
        }
        if (symbol == 'e'){
            isOver = true;
        }
        return bombs;
    }

    private static char[][] createMatrix(int size,Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int r = 0; r < matrix.length; r++) {
            String[] col = scanner.nextLine().split("\\s+");
            for (int c = 0; c < col.length; c++) {
                char symbol = col[c].charAt(0);
                matrix[r][c] = symbol;
            }
        }
        return matrix;
    }
    private static boolean isInBounds(int newRow, int newCol, char[][] field) {
        return newRow >= 0 && newRow < field.length && newCol >= 0 && newCol < field[newRow].length;
    }
}
