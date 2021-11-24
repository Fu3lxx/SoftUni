package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] arr = getArr(scanner);

        int rows = arr[0];
        int cols = arr[1];

        int [][] first = new int[rows][cols];

        for (int row = 0; row <rows ; row++) {
            first[row] = getArr(scanner);
        }

        int [] arr2 = getArr(scanner);
        int rows2 = arr2[0];
        int cols2 = arr2[1];
        int [][] second = new int[rows2][cols2];

        for (int row = 0; row < rows2; row++) {
            second[row] = getArr(scanner);
        }

        if (equalMatrix(first,second)){
            System.out.println("equal");
        }
        else {
            System.out.println("not equal");
        }



    }

    private static boolean equalMatrix(int[][] first, int[][] second) {
        boolean flag = true;
        int row1 = first.length;
        int col1 = first[0].length;

        int row2 = second.length;
        int col2 = second[0].length;

        if (row1 != row2 || col1 != col2){
            flag=false;
        }
        else {
            for (int i = 0; i <row1 ; i++) {
                for (int j = 0; j <col1 ; j++) {
                    if (first[i][j] != second[i][j]){
                        flag=false;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    private static int[] getArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static void printMatrix(int[][] first) {
        for (int i = 0; i < first.length; i++) {
            int [] temp = first[i];
            for (int j = 0; j < temp.length; j++) {
                System.out.print(temp[j] + " ");
            }
            System.out.println();
        }
    }
}
