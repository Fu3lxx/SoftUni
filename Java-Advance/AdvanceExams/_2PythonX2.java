package AdvanceExams;

import java.util.Scanner;

public class _2PythonX2 {
    static char[][] matrix;
    static int row;
    static int col;
    static int totalFood = 0;
    static int eatenFood = 0;
    static int pythonLength = 1;
    static boolean killedByEnemy = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        matrix = createMatrix(scanner,size);

        for (int i = 0; i <commands.length ; i++) {
            String command = commands[i];
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
            if (killedByEnemy){
                break;
            }
        }
        if (totalFood == 0){
            System.out.printf("You win! Final python length is %d",pythonLength);
        }
        else if (killedByEnemy){
            System.out.println("You lose! Killed by an enemy!");
        }
        else {
            System.out.printf("You lose! There is still %d food to be eaten.",totalFood);
        }
    }

    private static void move(int newRow, int newCol, int size) {
        if (newRow < 0 || newRow > size-1 ||newCol < 0 || newCol > size-1){
            if (newRow < 0){
                newRow = size-1;
            }else if (newRow > size-1){
                newRow = 0;
            }else if (newCol < 0){
                newCol = size-1;
            }else if (newCol > size-1){
                newCol = 0;
            }
        }
        char symbol = matrix[newRow][newCol];
        if (symbol == 'f'){
            pythonLength++;
            totalFood--;
            eatenFood++;
        }
        else if (symbol == 'e'){
            killedByEnemy = true;
        }
        row = newRow;
        col = newCol;
        matrix[row][col] = '*';
    }

    private static char[][] createMatrix(Scanner scanner, int size) {
        char[][] temp = new char[size][size];
        for (int r = 0; r < size; r++) {
            String[] arr = scanner.nextLine().split("\\s+");
            for (int c = 0; c < size; c++) {
                char symbol = arr[c].charAt(0);
                temp[r][c] = symbol;
                if (symbol == 's'){
                    row = r;
                    col = c;
                }
                else if (symbol == 'f'){
                    totalFood++;
                }
            }
        }
        return temp;
    }
}
