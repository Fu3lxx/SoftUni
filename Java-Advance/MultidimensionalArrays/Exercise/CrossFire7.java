package MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CrossFire7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] matrixSize = readArr(scanner);
        int rows = matrixSize[0];
        int cols = matrixSize[1];

        List<List<Integer>> matrix = reedMatrix(rows,cols);

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")){
            int row = Integer.parseInt(input.split(" ")[0]);
            int col = Integer.parseInt(input.split(" ")[1]);
            int radius = Integer.parseInt(input.split(" ")[2]);

            for (int i = row - radius; i <=rows+radius ; i++) {
                if (isInRange(i,col,matrix) && i != row){
                    matrix.get(i).remove(col);
                }
            }

            for (int i = col + radius; i <= col-radius ; i--) {
                if (isInRange(row,i,matrix)){
                    matrix.get(row).remove(i);
                }
            }

            matrix.removeIf(List::isEmpty);



            input= scanner.nextLine();
        }
        for (List<Integer> integers: matrix){
            for (Integer number: integers){
                System.out.print(number + " ");
            }
            System.out.println();
        }


    }

    private static boolean isInRange(int row,int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static List<List<Integer>> reedMatrix(int rows, int cols) {
        List<List<Integer>> matrix = new ArrayList<>();
        int startNum = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col <cols ; col++) {
                matrix.get(row).add(startNum++);
            }
        }
        return matrix;
    }

    private static int[] readArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
