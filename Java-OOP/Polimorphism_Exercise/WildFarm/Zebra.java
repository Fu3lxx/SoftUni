package Polimorphism_Exercise.WildFarm;

public class Zebra extends Mammal{

    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eatFood(Food food) {
        if (food instanceof Vegetable){
            super.eatFood(food);
        }else {
            throw new IllegalArgumentException(getClass().getSimpleName() + "s are not eating that type of food!");
        }
    }
}
