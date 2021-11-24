package WorkingWithAbstractionExercise.greedyTimes;

public class Safe {
    private String[] safe;
    private int index;
    private int safeSize;

    public Safe(String items){
        this.safe = items.split("\\s+");
        this.index = 0;
        this.safeSize = this.safe.length/2;
    }

    public String getItem(){
        String item = safe[index];
        index++;
        return item;
    }
    public int getAmount(){
        int amount = Integer.parseInt(safe[index]);
        index++;
        return amount;
    }

    public int getSafeSize() {
        return safeSize;
    }
    public boolean safeIsEmpty(){
        return index==safe.length;
    }
}
