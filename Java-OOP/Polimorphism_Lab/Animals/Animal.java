package Polimorphism_Lab.Animals;

public abstract class Animal {
    private String name;
    private String favoriteFood;

    protected Animal(String name, String favoriteFood) {
        this.setName(name);
        this.setFavoriteFood(favoriteFood);
    }

    public  String explainSelf(){
        return String.format("I am %s and my favourite food is %s",
                this.getName(),this.getFavoriteFood());
    }

    public String getName() {
        return name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }
}
