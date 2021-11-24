package AdvanceExams;

import java.util.Scanner;

public class _1FormulaOne {
    static char[][] matrix;
    static int row;
    static int col;
    static boolean finished = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int times = Integer.parseInt(scanner.nextLine());
        matrix = createMatrix(scanner,size);

        for (int i = 0; i <times ; i++) {
            if (finished){
                break;
            }
            String command = scanner.nextLine();
            switch (command){
                case "up":
                    move(row-1,col,size,command);
                    break;
                case "down":
                    move(row+1,col,size,command);
                    break;
                case "right":
                    move(row,col+1,size,command);
                    break;
                case "left":
                    move(row,col-1,size,command);
                    break;
            }
        }
        if (finished){
            System.out.println("Well done, the player won first place!");
        }else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(matrix,size);
    }

    private static void printMatrix(char[][] matrix, int size) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void move(int newRow, int newCol, int size,String direction) {
        matrix[row][col] = '.';
        if (newRow < 0 || newRow > size-1 || newCol < 0 || newCol > size-1){
            if (newRow < 0){
                newRow = size-1;
            }else if(newRow > size-1){
                newRow = 0;
            }else if (newCol < 0){
                newCol = size-1;
            }else if (newCol > size-1){
                newCol = 0;
            }


        }
        char symbol = matrix[newRow][newCol];
        if (symbol == 'B'){

            if (direction.equals("up")){
                newRow -=1;
            }else if (direction.equals("down")){
                newRow +=1;
            }else if (direction.equals("right")){
                newCol +=1;
            }else if (direction.equals("left")){
                newCol -=1;
            }
            if (newRow < 0 || newRow > size-1 || newCol < 0 || newCol > size-1) {
                if (newRow < 0) {
                    newRow = size - 1;
                } else if (newRow > size - 1) {
                    newRow = 0;
                } else if (newCol < 0) {
                    newCol = size - 1;
                } else if (newCol > size - 1) {
                    newCol = 0;
                }
            }
            symbol = matrix[newRow][newCol];
            if (symbol == 'F'){
                finished=true;
            }
        }
        else if (symbol == 'T'){
            newRow = row;
            newCol = col;
        }
        else if (symbol =='F'){
            finished=true;
        }

        row = newRow;
        col = newCol;
        matrix[row][col] = 'P';
    }

    private static char[][] createMatrix(Scanner scanner, int size) {
        char[][] temp = new char[size][size];
        for (int r = 0; r < size; r++) {
            String[] arr = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                char symbol = arr[c].charAt(0);
                temp[r][c] = symbol;
                if (symbol == 'P'){
                    row = r;
                    col = c;
                }
            }
        }
        return temp;
    }
}
