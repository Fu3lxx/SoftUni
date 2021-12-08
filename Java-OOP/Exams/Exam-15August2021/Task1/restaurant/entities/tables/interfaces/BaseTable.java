package restaurant.entities.tables.interfaces;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table{
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        isReservedTable = false;
    }

    public void setSize(int size) {
        if (size < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }
    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return false;
    }

    @Override
    public double allPeople() {
        return numberOfPeople * pricePerPerson;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        this.isReservedTable = true;

    }
    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        return allPeople +
                beverages.stream().mapToDouble(Beverages::getPrice).sum() +
                healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
    }

    @Override
    public void clear() {
        beverages.clear();
        healthyFood.clear();
        isReservedTable = false;
        this.numberOfPeople = 0;
    }

    @Override
    public String tableInformation() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Table - %d",number)).append(System.lineSeparator());
        builder.append(String.format("Size - %d",size)).append(System.lineSeparator());
        builder.append(String.format("Type - %s",this.getClass().getSimpleName())).append(System.lineSeparator());
        builder.append(String.format("All price - %.2f",pricePerPerson)).append(System.lineSeparator());
        return builder.toString().trim();
    }
}
