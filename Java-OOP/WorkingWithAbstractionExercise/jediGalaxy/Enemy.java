package WorkingWithAbstractionExercise.jediGalaxy;

public class Enemy {
    private Field field;
    public int row;
    private int col;

    public Enemy(Field field){
        this.field = field;
        this.row = 0;
        this.col = 0;
    }
    public void destroyStars(){
        while (row >= 0 && col >= 0){
            if (row >= 0 && row< field.getLength() && col >= 0 && col < field.getDimensionLength(0)){
                this.field.setCell(row, col, 0);
            }
            row--;
            col--;
        }
    }



    public void setNewStart(int row,int col){
        this.row = row;
        this.col = col;
    }
}
