package Polimorphism_Exercise.Vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double litersPerKm;

    public Vehicle(double fuelQuantity, double litersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
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
        this.fuelQuantity += amount;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),fuelQuantity);
    }
}
