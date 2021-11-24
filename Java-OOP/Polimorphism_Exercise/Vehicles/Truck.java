package Polimorphism_Exercise.Vehicles;

public class Truck extends Vehicle {
    private final static double AIR_CONDITIONER = 1.6;

    public Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm + AIR_CONDITIONER);
    }


    @Override
    public void refuel(double amount) {
        super.refuel(amount * 0.95);
    }
}
