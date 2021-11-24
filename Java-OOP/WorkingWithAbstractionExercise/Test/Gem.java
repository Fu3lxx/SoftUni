package WorkingWithAbstractionExercise.Test;

public class Gem implements Comparable<Gem> {
    private String name;
    private int amount;

    public Gem(String name,int amount){
        this.name = name;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Gem o) {
        return 0;
    }
}
