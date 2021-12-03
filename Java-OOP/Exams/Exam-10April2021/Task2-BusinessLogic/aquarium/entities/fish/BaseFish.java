package aquarium.entities.fish;

import static aquarium.common.ExceptionMessages.*;

public abstract class BaseFish implements Fish{

    private String name;
    private String species;
    private int size;
    private double price;
    private int increaseSizeBy = 5;

    public BaseFish(String name, String species, double price) {
        this.setName(name);
        this.setSpecies(species);
        this.setPrice(price);
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(FISH_NAME_NULL_OR_EMPTY);
        }
        this.name =name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSpecies(String species) {
        if (species == null || species.trim().isEmpty()){
            throw new NullPointerException(SPECIES_NAME_NULL_OR_EMPTY);
        }
        this.species = species;
    }

    public void setPrice(double price) {
        if (price <= 0){
            throw new IllegalArgumentException(FISH_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        this.price = price;
    }

    public void setIncreaseSizeBy(int increaseSizeBy) {
        this.increaseSizeBy = increaseSizeBy;
    }

    @Override
    public void eat() {
        this.size += increaseSizeBy;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
