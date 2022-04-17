package Polymorphism.Vehicles;

public class Bus extends Vehicle {
    private static final double FUEL_CONSUMPTION_PER_KM = 1.4;

    public Bus(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity);
    }

    public String driveWithPassenger(double distance) {
      /*  super.addConsumption(FUEL_CONSUMPTION_PER_KM);
        String out = super.drive(distance);
        super.subtractConsumption(FUEL_CONSUMPTION_PER_KM);*/
        return super.doWithIncreasedConsumption(FUEL_CONSUMPTION_PER_KM, ()-> super.drive(distance));
    }
}
