package AdvanceExams;

import java.util.Scanner;

public class _2Selling {
    static char[][] matrix;
    static int row;
    static int col;
    static int money;
    static int[] firstPillar = new int[]{-1,-1};
    static int[] secondPillar = new int[]{-1,-1};
    static boolean outOfBakery = false;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size =Integer.parseInt(scanner.nextLine());
        matrix = createMatrix(scanner,size);

        while (money < 50 || !outOfBakery){
            if (outOfBakery || money >= 50){
                break;
            }
            String command = scanner.nextLine();

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
        }
        if (outOfBakery){
            System.out.println("Bad news, you are out of the bakery.");
        }
        else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + money);
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

    private static void move(int newRow, int newCol, int size) {
        matrix[row][col] = '-';
        if (newRow > size-1 || newRow < 0 || newCol > size-1 || newCol < 0){
            outOfBakery = true;
        }
        else {
            char symbol = matrix[newRow][newCol];
            if (symbol == 'O'){
                matrix[newRow][newCol] = '-';
                if (firstPillar[0] == newRow){
                    newRow = secondPillar[0];
                    newCol = secondPillar[1];
                }else {
                    newRow = firstPillar[0];
                    newCol = firstPillar[1];
                }
            }
            else if (Character.isDigit(symbol)){
                money += Integer.parseInt(String.valueOf(symbol));
            }
            row = newRow;
            col = newCol;
            matrix[row][col] = 'S';
        }
    }

    private static char[][] createMatrix(Scanner scanner, int size) {
        char [][] temp = new char[size][size];
        for (int r = 0; r < size; r++) {
            String[] arr = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                char symbol = arr[c].charAt(0);
                temp[r][c] = symbol;
                if (symbol == 'S'){
                    row = r;
                    col = c;
                }
                if (symbol == 'O'){
                    if (firstPillar[0] == -1){
                        firstPillar[0] = r;
                        firstPillar[1] = c;
                    }else {
                        secondPillar[0] = r;
                        secondPillar[1] = c;
                    }
                }
            }
        }
        return temp;
    }
}
