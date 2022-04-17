package Encapsulation.PizzaCalories4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       /* String input = scanner.nextLine();
        String pizzaName = input.split("\\s+")[1];
        int numberOfToppings = Integer.parseInt(input.split("\\s+")[2]);
        Pizza pizza = null;
        try {
             pizza = new Pizza(pizzaName, numberOfToppings);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return;
        }
        input = scanner.nextLine();
        String flourType = input.split("\\s+")[1];
        String bakingTechnique = input.split("\\s+")[2];
        double weightInGrams = Double.parseDouble(input.split("\\s+")[3]);
        Dough dough = null;
        try {
            dough = new Dough(flourType, bakingTechnique, weightInGrams);
            pizza.setDough(dough);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return;
        }

        input = scanner.nextLine();

        while (!input.equals("END")){
            String nameTopping = input.split("\\s+")[1];
            double weightGrams = Double.parseDouble(input.split("\\s+")[2]);
            Topping topping = null;
            try {
                 topping = new Topping(nameTopping, weightGrams);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                return;
            }
            pizza.addTopping(topping);
            input = scanner.nextLine();
        }
        System.out.println();*/
    }
}
