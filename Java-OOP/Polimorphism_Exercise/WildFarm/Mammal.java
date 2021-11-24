package Polimorphism_Exercise.WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends  Animal{
    private String livingRegion;

    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    protected String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]",getAnimalType(),getAnimalName(), formatter.format(getAnimalWeight()),getLivingRegion(),getFoodEaten());
    }
}
