package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        toys = new ToyRepository();
        houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        if (type.equals("LongHouse")){
            house = new LongHouse(name);
        }else if (type.equals("ShortHouse")){
            house = new ShortHouse(name);
        }else {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        this.houses.add(house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE,type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        if (type.equals("Ball")){
            toy = new Ball();
        }else if (type.equals("Mouse")){
            toy = new Mouse();
        }else {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE,type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);
        House house = houses.stream().filter(h-> h.getName().equals(houseName)).findFirst().orElse(null);
        if (toy == null){
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND,toyType));
        }
        house.buyToy(toy);
        toys.removeToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE,toyType,houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        if (catType.equals("LonghairCat")){
            cat = new LonghairCat(catName,catBreed,price);
        }else if (catType.equals("ShorthairCat")){
            cat = new ShorthairCat(catName,catBreed,price);
        }else {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        House house = houses.stream().filter(h-> h.getName().equals(houseName)).findFirst().orElse(null);
        String houseType;
        if (house==null){
            throw new IllegalArgumentException("UNKNOWN HOUSE");
        }else {
            if (house.getClass().getSimpleName().equals("ShortHouse")){
                houseType = "Short";
            }else {
                houseType = "Long";
            }
        }

        if (cat.getClass().getSimpleName().contains(houseType)){
            house.addCat(cat);
            return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE,catType,houseName);
        }else {
            return UNSUITABLE_HOUSE;
        }

    }

    @Override
    public String feedingCat(String houseName) {
        House house = houses.stream().filter(h-> h.getName().equals(houseName)).findFirst().orElse(null);
        house.getCats().forEach(Cat::eating);
        return String.format(FEEDING_CAT,house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = houses.stream().filter(h-> h.getName().equals(houseName)).findFirst().orElse(null);
        double value = house.getCats().stream().mapToDouble(Cat::getPrice).sum()
                + house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        return String.format(VALUE_HOUSE,houseName,value);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        for (House house:houses){
            builder.append(house.getStatistics()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
