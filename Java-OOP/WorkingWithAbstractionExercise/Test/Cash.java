package WorkingWithAbstractionExercise.Test;

public class Cash implements Comparable<Cash>{
    private int amount;
    private String name;

    public Cash(String name,int amount){
        this.name = name;
        this.amount =amount;
    }

    @Override
    public int compareTo(Cash o) {
        return 0;
    }
}
