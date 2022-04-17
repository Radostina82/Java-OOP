package Polymorphism.Vehicles;

import java.text.DecimalFormat;
import java.util.function.Supplier;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.tankCapacity = tankCapacity;
        setFuelQuantity(fuelQuantity);
    }

    public void setFuelQuantity(double fuelQuantity) {

        this.fuelQuantity = fuelQuantity;
    }
   /* protected void addConsumption(double additionalConsumption){
        this.fuelConsumptionPerKm += additionalConsumption;
    }

    protected void subtractConsumption(double subtraction){
        this.fuelConsumptionPerKm -= subtraction;
    }*/
    protected <T> T doWithIncreasedConsumption(double additionalConsumption, Supplier<T> supplier){
        this.fuelConsumptionPerKm += additionalConsumption;
        try {
            return supplier.get();
        }catch (Throwable ex){
            throw new IllegalArgumentException(ex);
        }finally {
            this.fuelConsumptionPerKm -= additionalConsumption;
        }
    }
    private void validateNonNegativeFuel(double litter){
        if (litter <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }
    private void validateHasEnoughFreeTankCapacity(double additionalFuel){
        if (additionalFuel > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }
    protected String drive(double distance) {
        double neededFuel = distance * this.fuelConsumptionPerKm;
        if (this.fuelQuantity < neededFuel) {
            return this.getClass().getSimpleName() + " needs refueling";
        }

        this.setFuelQuantity(this.fuelQuantity - neededFuel);
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), formatter.format(distance));
    }

    protected void refuel(double liters) {
        validateNonNegativeFuel(liters);
        validateHasEnoughFreeTankCapacity(liters);
        setFuelQuantity(this.fuelQuantity += liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

}
