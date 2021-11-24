package Polimorphism_Exercise.VehiclesExtension;

public class Car extends Vehicle{
    private final static double AIR_CONDITIONER = 0.9;

    public Car(double fuelQuantity, double litersPerKm, int tankCapacity) {
        super(fuelQuantity, litersPerKm + AIR_CONDITIONER, tankCapacity);
    }
}
