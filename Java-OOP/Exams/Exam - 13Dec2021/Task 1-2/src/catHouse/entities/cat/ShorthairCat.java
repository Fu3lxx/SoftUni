package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    private static final int KILOGRAMS = 7;
    private static final int INCREASE_KILOGRAMS_BY_EATING = 1;
    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(KILOGRAMS);
    }

    @Override
    public void eating() {
        super.setKilograms(getKilograms() + INCREASE_KILOGRAMS_BY_EATING);
    }
}
