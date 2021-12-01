package bakery.core;

import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import static bakery.common.ExceptionMessages.*;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double totalIncome;


    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        totalIncome = 0;
    }


    @Override
    public String addFood(String type, String name, double price) {
        if (foodRepository.getByName(name) != null){
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,type,name));
        }
        BakedFood baseFood  = null;
        if (type.equals("Bread")){
            baseFood = new Bread(name,price);
        }else if (type.equals("Cake")) {
            baseFood = new Cake(name, price);
        }
        foodRepository.add(baseFood);
        return String.format(FOOD_ADDED,name,type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        if (drinkRepository.getByNameAndBrand(name,brand) != null){
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,type,name));
        }
        Drink drink = null;
        if (type.equals("Tea")){
            drink = new Tea(name, portion, brand);
        }else if(type.equals("Water")) {
            drink = new Water(name, portion, brand);
        }
        drinkRepository.add(drink);
        return String.format(DRINK_ADDED,name,brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        if (tableRepository.getByNumber(tableNumber) != null){
            throw new IllegalArgumentException(String.format(TABLE_EXIST,tableNumber));
        }
        Table table = null;
        if (type.equals("InsideTable")){
            table = new InsideTable(tableNumber,capacity);
        }else if (type.equals("OutsideTable")){
            table = new OutsideTable(tableNumber,capacity);
        }
        tableRepository.add(table);
        return String.format(TABLE_ADDED,tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        Table table = tableRepository.getAll().stream()
                .filter(tab-> tab.getCapacity()>= numberOfPeople && !tab.isReserved())
                .findFirst().orElse(null);
        if (table == null){
            return String.format(RESERVATION_NOT_POSSIBLE,numberOfPeople);
        }
        table.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED,table.getTableNumber(),numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table table = tableRepository.getByNumber(tableNumber);
        if (table == null ){
            return String.format(WRONG_TABLE_NUMBER,tableNumber);
        }
        BakedFood food = foodRepository.getByName(foodName);
        if (food == null){
            return String.format(NONE_EXISTENT_FOOD,foodName);
        }

        table.orderFood(food);
        return String.format(FOOD_ORDER_SUCCESSFUL,tableNumber,foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table table = tableRepository.getByNumber(tableNumber);
        if (table == null){
            return (String.format(WRONG_TABLE_NUMBER,tableNumber));
        }
        Drink drink = drinkRepository.getByNameAndBrand(drinkName,drinkBrand);
        if (drink==null){
            return (String.format(NON_EXISTENT_DRINK,drinkName,drinkBrand));
        }
        table.orderDrink(drink);
        return String.format(DRINK_ORDER_SUCCESSFUL,tableNumber,drinkName,drinkBrand);

    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = tableRepository.getByNumber(tableNumber);
        double bill;
        
        bill = table.getBill();
        totalIncome+= bill;
        table.clear();
        return String.format(BILL,tableNumber,bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder builder = new StringBuilder();
        tableRepository.getAll().stream().filter(table -> !table.isReserved()).forEach(table->builder.append(table.getFreeTableInfo()).append(System.lineSeparator()));
        return builder.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME,totalIncome);
    }
}
