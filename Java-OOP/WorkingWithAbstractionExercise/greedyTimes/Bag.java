package WorkingWithAbstractionExercise.greedyTimes;


import java.util.*;


public class Bag {
    private long capacity;
    private int gold;
    private Map<String, Integer> gems;
    private Map<String,Integer> cash;

    public Bag(long capacity){
        this.capacity = capacity;
        this.gold = 0;
        this.gems = new LinkedHashMap<>();
        this.cash = new LinkedHashMap<>();
    }
    public void addCash(String cashType, int amount) {
        if (totalGems() >= totalCash() +amount && capacity >= totalItems() + amount){
            cash.putIfAbsent(cashType,0);
            int currentCash = cash.get(cashType);
            cash.put(cashType,currentCash+amount);
        }
    }

    public void addGold(int amount) {
        if (capacity >= totalItems() + amount){
            gold+=amount;
        }
    }

    public void addGem(String gemName, int amount) {
        if (gold >= totalGems() + amount && capacity >= totalItems() + amount){
            gems.putIfAbsent(gemName,0);
            int currentGems = gems.get(gemName);
            gems.put(gemName,currentGems + amount);
        }
    }
    public void printBagData(){

        System.out.printf("<Gold> $%d\n",gold);
        System.out.printf("##Gold - %d\n",gold);

        if (gems.size() > 0){
            System.out.printf("<Gem> $%d\n",gems.values().stream().mapToInt(d->d).sum());
            gems.entrySet().stream().sorted((g1,g2)-> g2.getKey().compareTo(g1.getKey())).forEach(gem-> System.out.printf("##%s - %d\n",gem.getKey(),gem.getValue()));
        }
        if (cash.size() > 0){
            System.out.printf("<Cash> $%d\n",cash.values().stream().mapToInt(d->d).sum());
            cash.entrySet().stream().sorted((g1,g2)-> g2.getKey().compareTo(g1.getKey())).forEach(cash-> System.out.printf("##%s - %d\n",cash.getKey(),cash.getValue()));
        }

    }
    private int totalItems(){
        return gold + cash.values().stream().mapToInt(c->c).sum() + gems.values().stream().mapToInt(c->c).sum();
    }
    private int totalGems(){
        return gems.values().stream().mapToInt(d->d).sum();
    }
    private int totalCash(){
        return cash.values().stream().mapToInt(d->d).sum();
    }




}
