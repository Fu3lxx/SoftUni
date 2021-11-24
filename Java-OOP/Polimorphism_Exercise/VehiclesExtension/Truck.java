package Polimorphism_Exercise.VehiclesExtension;

public class Truck extends Vehicle{
    private final static double AIR_CONDITIONER = 1.6;

    public Truck(double fuelQuantity, double litersPerKm, int tankCapacity) {
        super(fuelQuantity, litersPerKm + AIR_CONDITIONER, tankCapacity);
    }

    @Override
    public void refuel(double amount) {
        super.refuel(amount * 0.95);
    }
}
