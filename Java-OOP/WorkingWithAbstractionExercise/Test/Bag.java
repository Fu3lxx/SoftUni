package WorkingWithAbstractionExercise.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Bag {
    private long capacity;
    private Set<Gem> gems;
    private Set<Cash> cash;

    public Bag(long capacity){
        this.capacity = capacity;
        this.gems = new TreeSet<>();
        this.cash = new TreeSet<>();
    }
    public void printGems(){
        for (var gem:gems){
            System.out.printf("%s - %d\n",gem.getName(),gem.getAmount());
        }
    }
    public void addGem(Gem gem){
        gems.add(gem);
    }
    public void sortGems(){

    }
}
