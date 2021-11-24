package Encapsulation_Exercise.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight){
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setBakingTechnique(String bakingTechnique) {
        this.bakingTechnique = bakingTechnique;
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")){
            this.flourType = flourType;
        }else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight< 1 || weight >200){
            throw new IllegalArgumentException("Encapsulation_Exercise.PizzaCalories.Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        double flourTypeModification = this.getFlourTypeModification();
        double bakingTechniqueModification = this.getBakingModification();

        return (2 * this.weight) * flourTypeModification * bakingTechniqueModification;
    }

    private double getBakingModification() {
        if (bakingTechnique.equals("Crispy")){
            return 0.9;
        }else if (bakingTechnique.equals("Chewy")){
            return 1.1;
        }else if (bakingTechnique.equals("Homemade")){
            return 1;
        }else {
            return 0;
        }
    }

    private double getFlourTypeModification() {
        if (flourType.equals("White")){
            return 1.5;
        }else if (flourType.equals("Wholegrain")){
            return 1;
        }else {
            return 0;
        }
    }

}
