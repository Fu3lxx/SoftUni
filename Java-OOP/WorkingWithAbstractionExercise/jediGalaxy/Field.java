package WorkingWithAbstractionExercise.jediGalaxy;

public class Field {
    private int[][] filed;
    private int row;
    private int col;

    public Field(int row,int col){
        this.filed = new int[row][col];
        this.row = row;
        this.col = col;
    }

    public void fillField(){
        int counter = 0;
        for (int r = 0; r < this.row; r++) {
            for (int c = 0; c < this.col; c++) {
                this.filed[r][c] = counter++;

            }
        }
    }
    public void printField(){
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                System.out.print(filed[r][c] + " ");
            }
            System.out.println();
        }
    }

    public int getCell(int row,int col){
        return this.filed[row][col];
    }
    public void setCell(int row,int col,int newValue){
        this.filed[row][col] = newValue;
    }

    public int getDimensionLength(int dimension) {
        return this.filed[dimension].length;
    }

    public int getLength() {
        return this.filed.length;
    }
}
