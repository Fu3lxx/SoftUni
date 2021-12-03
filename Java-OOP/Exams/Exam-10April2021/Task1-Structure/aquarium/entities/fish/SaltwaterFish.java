package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish{
    private static final int SIZE = 5;
    private static final int INCREASE_SIZE_BY = 2;
    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(SIZE);
        super.setIncreaseSizeBy(INCREASE_SIZE_BY);
    }
}
