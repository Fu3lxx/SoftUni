package Polimorphism_Exercise.VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double litersPerKm;
    private int tankCapacity;

    public Vehicle(double fuelQuantity, double litersPerKm, int tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.litersPerKm = litersPerKm;
        this.setTankCapacity(tankCapacity);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity > 0){
            this.fuelQuantity = fuelQuantity;
        }else {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }

    protected void setTankCapacity(int tankCapacity) {
        if (tankCapacity > 0){
            this.tankCapacity = tankCapacity;
        }else {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }
    public void addFuelConsumption(double amount){
        this.litersPerKm += amount;
    }
    public void removeFuelConsumption(double amount){
        this.litersPerKm -= amount;
    }

    public String drive(double kilometers){
        double fuelNeeded = kilometers * litersPerKm;
        if (fuelNeeded < fuelQuantity){
            this.fuelQuantity -= fuelNeeded;
            DecimalFormat formatter = new DecimalFormat("##.##");
            return String.format("%s travelled %s km",this.getClass().getSimpleName(),formatter.format(kilometers));
        }
        return this.getClass().getSimpleName() + " needs refueling";
    }

    public void refuel(double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        else if (this.tankCapacity >= fuelQuantity + amount){
            this.fuelQuantity += amount;
        }else {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),fuelQuantity);
    }
}
