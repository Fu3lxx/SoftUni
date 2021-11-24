package Encapsulation_Exercise.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight){
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight>= 1 && weight <= 50){
            this.weight = weight;
        }else {
            throw new IllegalArgumentException(String.format("%.2f weight should be in the range [1..50].",weight));
        }
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Polimorphism_Exercise.WildFarm.Meat") || toppingType.equals("Veggies") || toppingType.equals("Cheese") || toppingType.equals("Sauce")){
            this.toppingType = toppingType;
        }else {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",toppingType));
        }
    }
    public double calculateCalories(){
        double toppingTypeMod = this.getToppingMod(toppingType);
        return 2* this.weight * toppingTypeMod;
    }


    private double getToppingMod(String toppingType) {
        switch (toppingType){
            case "Polimorphism_Exercise.WildFarm.Meat":
                return 1.2;
            case "Veggies":
                return 0.8;
            case "Cheese":
                return 1.1;
            case "Sauce":
                return 0.9;
            default:
                return 0;
        }
    }
}
