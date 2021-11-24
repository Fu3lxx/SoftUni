package WorkingWithAbstractionExercise.jediGalaxy;

public class Player {
    private Field field;
    private int row;
    private int col;
    private long stars;

    public Player(Field field){
        this.field = field;
        this.stars = 0;
    }
    public void collectStars(){
        while (row >= 0 && col < this.field.getLength()) {
            if (row >= 0 && row < field.getLength() && col >= 0 && col < field.getDimensionLength(0)) {
                this.stars += this.field.getCell(row, col);
            }

            col++;
            row--;
        }
    }
    public long getStars(){
        return this.stars;
    }
    public void setNewStart(int row, int col){
        this.row = row;
        this.col = col;
    }
}
