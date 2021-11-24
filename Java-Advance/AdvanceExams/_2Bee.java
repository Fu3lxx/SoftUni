package AdvanceExams;

import java.util.Scanner;

public class _2Bee {
    static int size;
    static char[][] matrix;
    static int row;
    static int col;
    static boolean outOfTheZone = false;
    static int pollinatedF = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        size = Integer.parseInt(scanner.nextLine());
        matrix = createMatrix(size,scanner);
        boolean gameOn = true;

        while (gameOn){
            String command = scanner.nextLine();
            switch (command){
                case "right":
                    move(row,col +1,"right");
                    break;
                case "left":
                    move(row,col -1,"left");
                    break;
                case "up":
                    move(row-1,col,"up");
                    break;
                case "down":
                    move(row+1,col,"down");
                    break;
                case "End":
                    gameOn = false;
                    break;
            }
            if (outOfTheZone){
                System.out.println("The bee got lost!");
                break;
            }

        }
        if (pollinatedF >= 5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n",pollinatedF);
        }
        else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n",5 - pollinatedF);
        }
        printMatrix(matrix);


    }

    private static void move(int newRow, int newCol,String direction) {
        matrix[row][col] = '.';
        if (isInBounds(newRow,newCol,size)){
            char symbol = matrix[newRow][newCol];

            if (symbol == 'f'){
                pollinatedF++;
                matrix[newRow][newCol] = 'B';
            }
            else if (symbol == 'O'){
                matrix[newRow][newCol] = '.';
                if (direction.equals("right")){
                    newCol++;
                }else if (direction.equals("left")){
                    newCol--;
                }else if (direction.equals("up")){
                    newRow--;
                }else if (direction.equals("down")){
                    newRow++;
                }
                if (isInBounds(newRow,newCol,size)){
                    if (matrix[newRow][newCol] == 'f'){
                        pollinatedF++;
                        matrix[newRow][newCol] = 'B';
                    }
                    else if (matrix[newRow][newCol] == '.'){
                        matrix[newRow][newCol] = 'B';
                    }
                }
                else {
                    outOfTheZone = true;
                }
            }
            else if (symbol == '.'){
                matrix[newRow][newCol] = 'B';
            }
            row = newRow;
            col = newCol;

        }
        else {
            outOfTheZone = true;
        }
    }
    private static boolean isInBounds(int newRow,int newCol,int size){
        return (newRow < size && newRow >= 0 && newCol < size && newCol >=0);
    }
    private static void printMatrix(char[][] mat){
        for (int r = 0; r <size ; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(mat[r][c] );
            }
            System.out.println();
        }
    }

    private static char[][] createMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            String[] arr = scanner.nextLine().split("");
            for (int c = 0; c < size; c++) {
                char symbol = arr[c].charAt(0);
                if (symbol == 'B'){
                    row = r;
                    col = c;
                }
                matrix[r][c] = symbol;
            }
        }

        return matrix;
    }
}
