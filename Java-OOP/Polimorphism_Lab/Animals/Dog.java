package Polimorphism_Lab.Animals;

public class Dog extends Animal {

    public Dog(String name, String favoriteFood) {
        super(name, favoriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("%s%nDJAFF",super.explainSelf());
    }
}
