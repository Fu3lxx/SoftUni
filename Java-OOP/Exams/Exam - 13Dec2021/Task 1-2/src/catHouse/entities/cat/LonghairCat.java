package catHouse.entities.cat;

public class LonghairCat extends BaseCat{
    private static final int KILOGRAMS = 9;
    private static final int INCREASE_KILOGRAMS_BY_EATING = 3;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(KILOGRAMS);
    }

    @Override
    public void eating() {
        super.setKilograms(getKilograms() + INCREASE_KILOGRAMS_BY_EATING);
    }
}
