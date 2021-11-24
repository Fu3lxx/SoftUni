package Encapsulation_Exercise.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings){
        this.setName(name);
        this.dough = null;
        this.setToppings(numberOfToppings);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() < 1 || name.trim().length() > 15){
            throw new IllegalArgumentException("Encapsulation_Exercise.PizzaCalories.Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setToppings(int number) {
        if (number >= 0 && number <= 10){
            this.toppings = new ArrayList<>(number);
        }else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }
    public void addTopping(Topping topping){
        if (this.toppings.size() < this.numberOfToppings){
            this.toppings.add(topping);
        }

    }
    public double getOverallCalories(){
        return this.dough.calculateCalories() + toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.getOverallCalories());
    }
}
