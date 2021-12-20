package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public abstract class BaseHouse implements House{
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        return this.toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (capacity > cats.size()){
            this.cats.add(cat);
        }else {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }
    //possible mistake
    @Override
    public void feeding() {
        cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        List<String> catNames = new ArrayList<>();
        String catsStr;
        if (cats.size() > 0){
            for (Cat cat:cats){
                catNames.add(cat.getName());
            }
            catsStr = String.join(" ",catNames);
        }else {
            catsStr = "none";
        }
        int totalSoftness = toys.stream().mapToInt(Toy::getSoftness).sum();

        builder.append(String.format("%s %s:",this.name,this.getClass().getSimpleName())).append(System.lineSeparator());
        builder.append(String.format("Cats: %s",catsStr)).append(System.lineSeparator());
        builder.append(String.format("Toys: %d Softness: %d",toys.size(),totalSoftness)).append(System.lineSeparator());
        return builder.toString().trim();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
