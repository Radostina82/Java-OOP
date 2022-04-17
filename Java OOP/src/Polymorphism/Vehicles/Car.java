package Polymorphism.Vehicles;

public class Car extends Vehicle{
    private static final double FUEL_CONSUMPTION_PER_KM = 0.9;
    protected Car(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm + FUEL_CONSUMPTION_PER_KM, tankCapacity);
    }
}
