package restaurant.entities.healthyFoods;

import restaurant.entities.healthyFoods.Food;

public class VeganBiscuits extends Food {
    private static final double InitialSaladPortion = 205;
    public VeganBiscuits(String name,  double price) {
        super(name, InitialSaladPortion, price);
    }
}
