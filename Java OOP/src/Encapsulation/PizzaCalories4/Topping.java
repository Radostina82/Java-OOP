package Encapsulation.PizzaCalories4;

public class Topping {
    private String toppingType;
    private double weight;


    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") || toppingType.equals("Veggies") || toppingType.equals("Cheese") || toppingType.equals("Sauce")) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 && weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        //(2 * 50) * 1.2 = 120.00 total calories.
        double modifiers = getModifier(this.toppingType);
        return 2 * this.weight * modifiers;
    }

    private double getModifier(String toppingType) {
        if (toppingType.equals("Meat")){
            return 1.2;
        }else if (toppingType.equals("Veggies")){
            return 0.8;
        }else if (toppingType.equals("Cheese")){
            return 1.1;
        }else if (toppingType.equals("Sauce")){
            return 0.9;
        }
        return 0;
    }
}
