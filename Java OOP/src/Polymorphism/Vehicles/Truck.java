package Polymorphism.Vehicles;

public class Truck extends Vehicle {
    private static final double FUEL_CONSUMPTION_PER_KM = 1.6;

    protected Truck(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm + FUEL_CONSUMPTION_PER_KM, tankCapacity);
    }
    @Override
    protected void refuel(double liters){
        super.refuel(liters * 0.95);
    }
}
