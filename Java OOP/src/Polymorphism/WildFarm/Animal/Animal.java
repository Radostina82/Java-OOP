package Polymorphism.WildFarm.Animal;

import Polymorphism.WildFarm.Food.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private int foodEaten;
    private String livingRegion;

    protected Animal(String animalType, String animalName,  Double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.livingRegion = livingRegion;
    }

    public String getAnimalType() {
        return animalType;
    }

    public abstract void makeSound();
   public  void eat(Food food){
       this.foodEaten += food.getQuantity();
   }
@Override
    public  String toString(){
    DecimalFormat decimalFormat = new DecimalFormat("##.##");
    return String.format("%s[%s, %s, %s, %d]", this.animalType, this.animalName, decimalFormat.format(this.animalWeight),this.livingRegion, this.foodEaten);
}
}
