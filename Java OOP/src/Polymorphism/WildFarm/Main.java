package Polymorphism.WildFarm;

import Polymorphism.WildFarm.Animal.*;
import Polymorphism.WildFarm.Food.Food;
import Polymorphism.WildFarm.Food.Meat;
import Polymorphism.WildFarm.Food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String evenLine = scanner.nextLine();

        List<Animal> animalList = new ArrayList<>();


        while (!evenLine.equals("End")) {

            Animal animal = createAnimal(evenLine.split("\\s+"));
            String oddLine = scanner.nextLine();
            Food food = createFood(oddLine.split("\\s+"));
            animal.makeSound();
            try {
                animal.eat(food);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
            animalList.add(animal);
            evenLine = scanner.nextLine();
        }
        for (Animal animal : animalList) {
            System.out.println(animal);
        }
    }

    private static Food createFood(String[] oddLine) {
        int quantity = Integer.parseInt(oddLine[1]);
            return oddLine[0].equals("Meat") ? new Meat(quantity) : new Vegetable(quantity);
    }

    private static Animal createAnimal(String[] evenLine) {
        Animal animal = null;
        if(evenLine[0].equals("Cat")){
        animal = new Cat(evenLine[0], evenLine[1], Double.parseDouble(evenLine[2]), evenLine[3], evenLine[4]);
        }else if (evenLine[0].equals("Tiger")){
            animal = new Tiger(evenLine[0], evenLine[1], Double.parseDouble(evenLine[2]), evenLine[3]);
        }else if (evenLine[0].equals("Mouse")){
            animal = new Mouse(evenLine[0], evenLine[1], Double.parseDouble(evenLine[2]), evenLine[3]);
        }else if (evenLine[0].equals("Zebra")){
            animal = new Zebra(evenLine[0], evenLine[1], Double.parseDouble(evenLine[2]), evenLine[3]);
        }
        return animal;
    }
}
