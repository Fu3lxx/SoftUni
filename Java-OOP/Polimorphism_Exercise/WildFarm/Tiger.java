package Polimorphism_Exercise.WildFarm;

public class Tiger extends Felime{
    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eatFood(Food food) {
        if (food instanceof Meat){
            super.eatFood(food);
        }else {
            throw new IllegalArgumentException(getClass().getSimpleName() + "s are not eating that type of food!");
        }
    }
}
