package AdvanceExams;

import java.util.Scanner;

public class _2Python {
    static int row;
    static int col;
    static int food = 0;
    static int length = 1;
    static boolean endGame = false;
    static char [][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        matrix = createMatrix(scanner,size);

        findFoodAndStartPosition(size, matrix);

        for (int i = 0; i <commands.length ; i++) {
            String command = commands[i];

            switch (command){
                case "up":
                    move(matrix,row-1,col,size);
                    break;
                case "down":
                    move(matrix,row+1,col,size);
                    break;
                case "left":
                    move(matrix,row,col-1,size);
                    break;
                case "right":
                    move(matrix,row,col+1,size);
                    break;

            }
            if (endGame){
                break;
            }
        }

        if (endGame){
            System.out.println("You lose! Killed by an enemy!");
        }
        else if (food > 0){
            System.out.printf("You lose! There is still %d food to be eaten.\n",food);
        }
        else {
            System.out.printf("You win! Final python length is %d\n",length);
        }


    }

    private static void move(char[][] matrix, int newRow, int newCol, int size) {
        boolean outOfMatrix = false;
        if (newCol < 0){
            col = size-1;
        }
        else if (newCol > size-1){
            col = 0;
        }
        else if (newRow < 0){
            row = size-1;
        }
        else if (newRow > size-1){
            row = 0;
        }
        else {
            row = newRow;
            col = newCol;
        }
        char symbol = matrix[row][col];

        if (symbol == 'f'){
            food--;
            length++;
            matrix[row][col] = '*';
        }
        else if (symbol == 'e'){
            endGame = true;
        }

    }

    private static void findFoodAndStartPosition(int size, char[][] matrix) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (matrix[r][c] == 'f'){
                    food++;
                }
                else if (matrix[r][c] == 's'){
                    row = r;
                    col = c;
                }
            }
        }
    }

    private static char[][] createMatrix(Scanner scanner, int size) {
        char [][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String[] elements = scanner.nextLine().split(" ");
            for (int cow = 0; cow < size; cow++) {
                matrix[row][cow] = elements[cow].charAt(0);
            }
        }
        return matrix;
    }
}
