package Inheritance.animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String typeAnimal = "";
        while (!input.equals("Beast!")) {
            String[] tokens = input.split("\\s+");
            String nameAnimal = "";
            int ageAnimal = -1;
            String gender = "";
            if (tokens.length == 1) {
                typeAnimal = tokens[0];
                input = scanner.nextLine();
                continue;
            } else if (tokens.length == 3) {
                nameAnimal = tokens[0];
                ageAnimal = Integer.parseInt(tokens[1]);
                gender = tokens[2];
            }
            try {


                if (typeAnimal.equals("Dog")) {
                    Dog dog = new Dog(nameAnimal, ageAnimal, gender);
                    System.out.println(dog);
                } else if (typeAnimal.equals("Frog")) {
                    Frog frog = new Frog(nameAnimal, ageAnimal, gender);
                    System.out.println(frog);
                } else if (typeAnimal.equals("Cat")) {
                    Cat cat = new Cat(nameAnimal, ageAnimal, gender);
                    System.out.println(cat);
                } else if (typeAnimal.equals("Kitten")) {
                    Kitten kitten = new Kitten(nameAnimal, ageAnimal);
                    System.out.println(kitten);
                } else if (typeAnimal.equals("Tomcat")) {
                    Tomcat tomcat = new Tomcat(nameAnimal, ageAnimal);
                    System.out.println(tomcat);
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            input = scanner.nextLine();
        }
    }
}
